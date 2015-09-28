/**
 * angular.js CRUD action (add, remove, update, query)
 * @param dataResolver
 * @param type
 * @param actionConfig
 * @returns {{}}
 * @constructor
 */
function Action(dataResolver, type, actionConfig) {
	var action = {};
	action.dataResolver = dataResolver;
	action.type = type;
	action.url = dataResolver.contextPath + "/" + dataResolver.servicePath + "/" + actionConfig.url;
	action.filters = {};
	action.preCommit = actionConfig.preCommit;

	/**
	 *   this function should be invoked by developer in page to begin to add or update model.
	 *   @param model the model to update or remove.
	 */
	action.begin = function (model) {
		dataResolver.activeAction = type;
		if (model == undefined) {
			action.dataResolver.current = {};
		} else {
			action.dataResolver.current = angular.copy(model);
		}
		dataResolver[dataResolver.validatorModelName] = {};
		actionConfig.begin(action.dataResolver.current);
	};

	// define action's commit() method
	if (type == "add" || type == "remove" || type == "update") {

		/**
		 *
		 * @param model  the model to be added, removed or updated.
		 */
		action.commit = function (model) {

			//dataResolver.preAction(type, model);

			if (action.preCommit != undefined) {
				action.preCommit(model);
			}

			var valid = true;
			if (dataResolver.validate != undefined) {

				valid = dataResolver.validate();
				console.log("validate()", valid);
			}
			if (valid) {
				dataResolver.preAction(type, model);
				console.log("Committing " + type, model);
				action.dataResolver.http(
					{
						method: 'POST',
						url: this.url,
						data: model
					}
				).success(
					function (data, status) {
						actionConfig.success(data, status);
						dataResolver.postAction(type, true, data, status);
						dataResolver.query.commit();
					}
				).error(
					function (data, status) {
						actionConfig.error(data, status);
						dataResolver.postAction(type, false, data, status);
					}
				);
			}
		}

	} else if (type == "query") {

		action.currentPage = 1;
		action.maxPerPage = 10;
		action.maxNumberedPage = 5;

		action.first = function () {
			this.commit(1);
		};
		action.previous = function () {
			this.commit(this.currentPage - 1);
		};
		action.next = function () {
			this.commit(this.currentPage + 1);
		};
		action.last = function () {
			this.commit(this.result.totalPage);
		};

		/**
		 * commit query action
		 * @param pageNumber
		 */
		action.commit = function (pageNumber) {

			dataResolver.preAction(type);

			if (pageNumber != null && pageNumber != undefined) {
				if (pageNumber <= 1) {
					this.currentPage = 1;
				} else if (pageNumber > this.result.totalPage) {
					this.currentPage = this.result.totalPage;
				} else {
					this.currentPage = pageNumber;
				}
			}
			if (this.currentPage == null || this.currentPage == undefined) {
				this.currentPage = 1;
			}
			console.log("Loading page " + this.currentPage);
			action.loadData(action);

		};

		action.loadData = function (self) {

			if (action.preCommit != undefined) {
				action.preCommit(action.filters);
			}
			var data;
			if (self.filters == undefined) {
				data = {}
			} else {
				data = self.filters;
			}
			data.page = self.currentPage;
			data.max = self.maxPerPage;
			console.log("Query filters:", data);

			self.dataResolver.http({
				method: 'POST',
				headers: {'Content-Type': 'application/x-www-form-urlencoded'},
				url: self.url,
				data: $.param(data)
			}).success(function (data, status) {
					console.log("query result:", data);
					self.result = data;

					if (data.totalPage <= 5) {
						self.numberedPages = [];
						for (var i = 1; i <= data.totalPage; i++) {
							self.numberedPages.push(i);
						}
						self.collapseLeft = false;
						self.collapseRight = false;

					} else {
						self.numberedPages = [];

						if (data.page <= 3) {
							for (i = 1; i <= 5; i++) {
								self.numberedPages.push(i);
							}
							self.collapseLeft = false;
							self.collapseRight = true;
						} else if (data.page >= data.totalPage - 2) {
							for (i = data.totalPage - 5 + 1; i <= data.totalPage; i++) {
								self.numberedPages.push(i);
							}
							self.collapseLeft = true;
							self.collapseRight = false;
						} else {
							for (i = data.page - 2; i <= data.page + 2; i++) {
								self.numberedPages.push(i);
							}
							self.collapseLeft = true;
							self.collapseRight = true;
						}

					}
					actionConfig.success(data, status);
					dataResolver.postAction(type, true, status);
				}
			).error(
				function (data, status) {
					actionConfig.error(data, status);
					dataResolver.postAction(type, false, status);
				}
			);
		};
	}
	return action;
}

/**
 * Create a data resolver is used to handle CRUD operations.
 * @param http angular.js $http object
 * @param resolverConfig
 * @returns {} the data resolver
 * @constructor
 */
function DataResolver(http, resolverConfig) {
	var resolver = {};
	resolver.http = http;
	resolver.contextPath = resolverConfig.contextPath;
	resolver.servicePath = resolverConfig.servicePath;
	resolver.current = {};

	if (resolverConfig.validatorModelName == undefined || resolverConfig.validatorModelName == '') {
		resolver.validatorModelName = "currentValidator";
	} else {
		resolver.validatorModelName = resolverConfig.validatorModelName;
	}

	resolver.activeAction = "";

	// assign preAction
	if (resolverConfig.preAction != undefined)
		resolver.preAction = resolverConfig.preAction;
	else
		resolver.preAction = function () {};

	// assign postAction
	if (resolverConfig.postAction != undefined)
		resolver.postAction = resolverConfig.postAction;
	else
		resolver.postAction = function () {};

	//fixme need imp
	resolver.validate = function () {
		resolver[resolver.validatorModelName] = {};
		if (resolverConfig[resolver.activeAction].validate != undefined)
			return resolverConfig[resolver.activeAction]
				.validate(resolver.current, resolver[resolver.validatorModelName]);
		else
			return true;
	};

	//fixme need imp
	resolver.commit = function (model) {
		var action = resolver[resolver.activeAction];
		if (action != undefined)
			action.commit(model);
	};


	if (resolverConfig.add != null) {

		resolver.add = Action(resolver, "add", resolverConfig.add);
	}
	if (resolverConfig.remove != null) {
		resolver.remove = Action(resolver, "remove", resolverConfig.remove);
	}
	if (resolverConfig.update != null) {
		resolver.update = Action(resolver, "update", resolverConfig.update);
	}
	if (resolverConfig.query != null) {
		resolver.query = Action(resolver, "query", resolverConfig.query);
	}
	if (resolverConfig.details != null) {
		resolver.details = Action(resolver, "details", resolverConfig.details);
	}
	return resolver;
}

