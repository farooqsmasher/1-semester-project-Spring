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

</head>

<body>

	<%@ include file="header.jsp"%>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">

			<%@ include file="adminmenu.jsp"%>
			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="home">Home</a>
						</li>
						<li class="active">File Uplaod</li>
					</ul>
					<!-- .breadcrumb -->


				</div>


				<div class="row">
					<div class="col-xs-10">
						<div class="space-12"></div>

						<!-- PAGE CONTENT BEGINS -->
						<c:if test="${!empty errorFlag}">
							<h4 class="header red lighter bigger" id="final_msg">Incorrect Encryption Key</h4>
							<script>
							setTimeout(function() {
								 $('#final_msg').fadeOut();
								 
								}, 5000 );
							</script>
						</c:if>
						<form class="form-horizontal" method="GET"
							action="downloadResquestedFile" enctype="multipart/form-data">
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-2 no-padding-right"
									for="fname">Choose File<sup style="color: red">*</sup>:
								</label>

								<div class="col-sm-8">
									<select name="fileId">
										<option value="">Select A File</option>
										<c:forEach items="${filesList}" var="fileIte">
											<option value="${fileIte.id}">${fileIte.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-2 no-padding-right"
									for="fname">Encrypted Key: </label>

								<div class="col-sm-8">
									<input type="text" name="encKey" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-2 no-padding-right">
								</label>
								<div class="col-sm-8">
									<input class="btn btn-success btn-next" value="Download"
										type="submit">
								</div>
							</div>




						</form>




					</div>
					<div class="row"></div>

					<div class="space-4"></div>

					<div class="col-sm-8">
						<div class="clearfix"></div>

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

	<script src="uiresources/assets/js/jquery.dataTables.min.js"></script>
	<script src="uiresources/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script type="text/javascript">
		jQuery(function($) {
			var oTable1 = $('#sample-table-2').dataTable({
				"aoColumns" : [

				null, null, null, {
					"bSortable" : false
				} ]
			});

			$('[data-rel="tooltip"]').tooltip({
				placement : tooltip_placement
			});
			function tooltip_placement(context, source) {
				var $source = $(source);
				var $parent = $source.closest('table')
				var off1 = $parent.offset();
				var w1 = $parent.width();

				var off2 = $source.offset();
				var w2 = $source.width();

				if (parseInt(off2.left) < parseInt(off1.left)
						+ parseInt(w1 / 2))
					return 'right';
				return 'left';
			}
		})
	</script>


</body>
</html>
