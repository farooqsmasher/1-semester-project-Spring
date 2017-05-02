<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html lang="en">
<head>
<meta charset="utf-8" />
<title>Employee</title>

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
						<li class="active">Update Users</li>
					</ul>
					<!-- .breadcrumb -->


				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>Update Users</h1>
					</div>
					<!-- /.page-header -->



					<div class="row">
						<div class="col-xs-12">
							<div style="float: right">
								<a href="usersList">
									<button class="btn btn-success btn-next">
										<i class="icon-arrow-left"></i> List All user
									</button>
								</a>
							</div>
							<h3 class="lighter block green">Enter the following
								information</h3>
						
										
										<form:form class="form-horizontal" 
									 method="POST" action="employee" commandName="tblUserVO">

                                      <div class="form-group">
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="username">Username<sup style="color:red">*</sup>:</label>

										<div class="col-sm-4">
											 
												<form:input type="text" path="tblUser.username"
													name="username" id="username" class="col-xs-12 col-sm-6" maxlength="50" required="true"/>
											
										</div>
										
									
								
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="password">Password<sup style="color:red">*</sup>:</label>

										<div class="col-sm-4">
											 
												<form:input type="password" path="tblUser.password"
													name="password" id="password" class="col-xs-12 col-sm-6"  />
													
											
										</div>

</div>

									 
									 <div class="form-group">
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="firstname">First Name<sup style="color:red">*</sup>:</label>

										<div class="col-sm-4">
											 
												<form:input type="text" path="tblUser.firstName"
													name="firstname" id="firstname" class="col-xs-12 col-sm-6" maxlength="50" required="true"/>
											
										</div>
										
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="lastname">Last Name<sup style="color:red">*</sup>:</label>

										<div class="col-sm-4">
											 
												<form:input type="text" path="tblUser.lastName"
													name="lastname" id="lastname" class="col-xs-12 col-sm-6" maxlength="50" required="true"/>
											
										</div>
								
										
									</div>
									
									
									<div class="form-group">
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="dob">Date Of Birth<sup style="color:red">*</sup>:</label>

										<div class="col-sm-4">
											 
												<form:input type="date" path="tblUser.dob"
													name="dob" id="dob" class="col-xs-12 col-sm-6" maxlength="50" required="true"/>
											
										</div>
										
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="email">Email:</label>

										<div class="col-sm-4">
											 
												<form:input type="text" path="tblUser.email"
													name="email" id="email" class="col-xs-12 col-sm-6" maxlength="50" />
											
										</div>
								
										
									</div>
									
									<div class="form-group">
										
										
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="mobileno">Mobile No:</label>

										<div class="col-sm-4">
											 
												<form:input type="text" path="tblUser.mobileNo"
													name="mobileno" id="mobileno" class="col-xs-12 col-sm-6" maxlength="50" />
											
										</div>
								
										
									
									
									
									
										
										
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="role">Role:<sup style="color:red">*</sup>:</label>

										<div class="col-sm-4">
											 
												<form:select type="text" path="tblUserRole.roleMaster.roleId"
													name="role" id="role" class="col-xs-12 col-sm-6"  required="true">
													<form:option value="">-select-</form:option>
													<c:forEach items="${roles}" var="role">
													<form:option value="${role.roleId}">${role.roleDesc}</form:option>
													</c:forEach>
													</form:select>
											
										</div>
								
										
									</div>
									
										<div class="form-group">
										
										
										<label
											class="control-label col-xs-12 col-sm-2 no-padding-right"
											for="mobileno">Designation:</label>

										<div class="col-sm-4">
											 
												<form:input type="text" path="tblUser.designation"
													name="Designation" id="designation" class="col-xs-12 col-sm-6" maxlength="50" />
											
										</div>
									
									</div>
									
								<input class="btn btn-success btn-next" type="submit">	
									 </form:form>
								



								
							
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


</body>
</html>
