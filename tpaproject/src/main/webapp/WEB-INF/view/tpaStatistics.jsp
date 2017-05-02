<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html lang="en">
<head>
<meta charset="utf-8" />
<title>TPA</title>

<%@ include file="headerlinks.jsp"%>
<!-- page specific plugin styles -->

<link rel="stylesheet" href="uiresources/assets/css/select2.css" />
<script src="uiresources/assets/js/highcharts.js"></script>
<script src="uiresources/assets/js/exporting.js"></script>

</head>

<body>

	<%@ include file="header.jsp"%>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

		<div class="main-container-inner">

			<%@ include file="adminmenu.jsp"%>
			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="home">Home</a>
						</li>
						<li class="active">User Files</li>
					</ul>
					<!-- .breadcrumb -->


				</div>
				<div class="page-content">
					<div class="page-header">
						<h1>User Files</h1>
					</div>
					<div class="row">
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto">

</div>
						
					</div>


				</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->


		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->


	<%@ include file="footer.jsp"%>
	<!-- page specific plugin scripts -->

	<script src="uiresources/assets/js/fuelux/fuelux.wizard.min.js"></script>
	<script src="uiresources/assets/js/jquery.validate.min.js"></script>
	<script src="uiresources/assets/js/additional-methods.min.js"></script>
	<script src="uiresources/assets/js/bootbox.min.js"></script>
	<script src="uiresources/assets/js/jquery.maskedinput.min.js"></script>
	<script src="uiresources/assets/js/select2.min.js"></script>
	
	<script src="uiresources/assets/js/jquery.dataTables.min.js"></script>
	<script src="uiresources/assets/js/jquery.dataTables.bootstrap.js"></script>

<script>
var fileCount =  new Array();
var auditFileCount =  new Array();
var users = new Array();
<c:forEach items="${userDownloadCount}" var="ite">
console.log('${ite}');
var item = "${ite}";
var itemArr = item.split(',');
users.push(itemArr[0]);
fileCount.push(parseInt(itemArr[1]));
auditFileCount.push(parseInt(itemArr[2]));
</c:forEach>
</script>



<script>

$(function () {
    
	Highcharts.chart('container', {
		
		 chart: {
	            type: 'column'
	        },
        title: {
            text: 'User Files',
            x: -20 //center
        },
        subtitle: {
            text: '',
            x: -20
        },
        xAxis: {
            categories: users
        },
        yAxis: {
            title: {
                text: 'Files'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '°C'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: 'Files',
            data: fileCount
        },{
            name: 'Audited Files',
            data: auditFileCount
        }]
    });
});
</script>


</body>
</html>
