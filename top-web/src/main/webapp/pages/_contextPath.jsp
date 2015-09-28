<script type="text/javascript">
  var contextPath = '${pageContext.request.contextPath}';

  function pageUrl(url) {
    return contextPath + url;
  }

  function header(param) {

    if (param.title != undefined) {
      $('#header-title').html(param.title);
    }

    if (param.back != null && param.back.length > 0) {
      var headerBackBtn = $('#header-back-btn');
      headerBackBtn.css('visibility', 'visible');
      headerBackBtn.click(function () { window.location.href = pageUrl(param.back)});
    }

    var dropdownBtn = $('#header-menu-btn');
    dropdownBtn.click(function () { $('#header-menu-btn').dropdown();});
    if (param.menu == null || param.menu) {
      dropdownBtn.css('visibility', 'visible');
    }
  }
</script>

