<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html lang="en">
<head>
<meta charset="utf-8" />
<title>USERS-DETAILS</title>

<%@ include file="headerlinks.jsp"%>
<!-- page specific plugin styles -->

<link rel="stylesheet" href="uiresources/assets/css/select2.css" />

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
						<li class="active">USERS-DETAILS</li>
					</ul>
					<!-- .breadcrumb -->


				</div>
				<div class="page-content">
					<div class="page-header">
						<h1>USERS-DETAILS</h1>
					</div>
					<div class="row">

						<div class="col-xs-12">
							<div class="table-header">List Of All Files..</div>

							<div class="table-responsive">
								<table id="sample-table-2"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>

											<th>username</th>
											<th>DOB</th>
											<th>email</th>
											<th>mobileNo</th>
											<th>designation</th>
											<th>update</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${usersList}" var="users">
											<tr>


												<td>${users.username}</td>
												<td>${users.dob}</td>
												<td>${users.email}</td>
												<td>${users.mobileNo}</td>
												<td>${users.designation}</td>
                                               <td><script>
														function openWindow(param){
															
															window.open("childProfileView?id="+param, "Child Profile", "height=600,width=800");	
															}
														</script>
																<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
																

																<a class="green" href="employeeUpdate?id=${users.username}">
																	<i class="icon-pencil bigger-130"></i>
																</a>

																
															</div>
														</td>
											</tr>



										</c:forEach>



									</tbody>
								</table>
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
	<script type="text/javascript">
			jQuery(function($) {
			
		</script>
	<script src="uiresources/assets/js/jquery.dataTables.min.js"></script>
	<script src="uiresources/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script type="text/javascript">
			jQuery(function($) {
				var oTable1 = $('#sample-table-2').dataTable( {
				"aoColumns": [
			      
			      null, null,null,null,null
				] } );
				
				
				
			
			
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			})
		</script>


</body>
</html>