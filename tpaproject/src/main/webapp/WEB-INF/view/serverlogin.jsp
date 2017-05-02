<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>TPA</title>

<meta name="description" content="User login page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- basic styles -->

<link href="uiresources/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet"
	href="uiresources/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="uiresources/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->

<!-- fonts -->

<link rel="stylesheet" href="uiresources/assets/css/ace-fonts.css" />

<!-- ace styles -->

<link rel="stylesheet" href="uiresources/assets/css/ace.min1.css" />
<link rel="stylesheet" href="uiresources/assets/css/ace-rtl.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="uiresources/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="uiresources/assets/js/html5shiv.js"></script>
		<script src="uiresources/assets/js/respond.min.js"></script>
		<![endif]-->
</head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #438eb9;
    text-align: center;
vertical-align: middle;
 float: center;
}

li {
    float: right;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
.active {
    background-color: black;
}
li a:hover {
    background-color: white;
}
</style>
 <ul>
  <li><a  href="tpalogin">TPA LOGIN</a></li>
  <li><a class="active" href="serverlogin">SERVER-LOGIN</a></li>
  <li><a  href="login">USER-LOGIN</a></li>

</ul>

<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class=" icon-cloud blue"></i> <span
									style="color: white; font-weight: 600">SERVER-LOGIN</span>
							</h1>
							<h2 style="color: #FF3385;"></h2>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<c:if test="${!empty logout}">
											<%
												session.invalidate();
											%>
										</c:if>

										<c:if test="${!empty accesserror}">
											<h4 class="header red lighter bigger">Incorrect Username
												or Password!!</h4>
										</c:if>
										
										<h4 style="color: #111515;">
											<i class="icon-coffee green"></i> Please Enter Your
											Information
										</h4>

										<div class="space-6"></div>

										<form action="j_spring_security_check" method="POST">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" name='j_username' class="form-control"
														placeholder="Username" /> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" name='j_password' class="form-control"
														placeholder="Password" /> <i class="icon-lock"></i>
												</span>
												</label>



												<div class="space"></div>
												<div class="clearfix">
													<label class="inline"> <input type="checkbox"
														class="ace" /> <span class="lbl"> Remember Me</span>
													</label>

												</div>
												<div class="clearfix">



													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> Login
													</button>
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

										
									<!-- /widget-main -->

								

										
							<!-- /login-box -->

							<div id="forgot-box" class="forgot-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header red lighter bigger">
											<i class="icon-key"></i> Retrieve Password
										</h4>

										<div class="space-6"></div>
										<p>Enter your email and to receive instructions</p>

										<form>
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" class="form-control" placeholder="Email" />
														<i class="icon-envelope"></i>
												</span>
												</label>

												<div class="clearfix">
													<button type="button"
														class="width-35 pull-right btn btn-sm btn-danger">
														<i class="icon-lightbulb"></i> Send Me!
													</button>
												</div>
											</fieldset>
										</form>
									</div>
									<!-- /widget-main -->

									<div class="toolbar center">
										<a href="#" onclick="show_box('login-box'); return false;"
											class="back-to-login-link"> Back to login <i
											class="icon-arrow-right"></i>
										</a>
									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /forgot-box -->

							<div id="signup-box" class="signup-box widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header green lighter bigger">
											<i class="icon-group blue"></i> New User Registration
										</h4>

										<div class="space-6"></div>
										<p>Enter your details to begin:</p>
										<c:if test="${not empty duplicateUSer}">
   											<p style="color: red;">Username Already Exists</p>
										</c:if>
										
										<form id="registrationForm">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="email" id="regEmail" name="regEmail"
														class="form-control" placeholder="Email" /> <i
														class="icon-envelope"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" id="regUsername" name="regUsername"
														class="form-control" placeholder="username"  /> <i
														class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" id="regPassword" name="regPassword"
														class="form-control" placeholder="Password" /> <i
														class="icon-lock"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" class="form-control"
														id="regRepeatPassword" name="regRepeatPassword"
														placeholder="Repeat password" /> <i class="icon-retweet"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="number" class="form-control"
														id="regmobileno" name="regmobileno"
														placeholder="moblie-number" />
														 <i class="icon-user"></i>
												</span>
													</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control"
														id="regdob" name="regdob"
														placeholder="DOB" />
														 <i class="icon-user"></i>
												</span>
												</span>
													</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control"
														id="regdesig" name="regdesig"
														placeholder="Designation" />
														 <i class="icon-user"></i>
												</span>
												</label> <label class="block"> <input type="checkbox"
													id="agreement" class="ace" /> <span class="lbl"> I
														accept the <a href="#">User Agreement</a>
												</span>
												</label>

												<div class="space-24"></div>

												<div class="clearfix">
													<button type="reset" class="width-30 pull-left btn btn-sm">
														<i class="icon-refresh"></i> Reset
													</button>

													<button type="button"
														class="width-65 pull-right btn btn-sm btn-success"
														onclick="registerUser()">
														Register <i class="icon-arrow-right icon-on-right"></i>
													</button>
												</div>
											</fieldset>
										</form>
									</div>

									<div class="toolbar center">
										<a href="#" onclick="show_box('login-box'); return false;"
											class="back-to-login-link"> <i class="icon-arrow-left"></i>
											Back to login
										</a>
									</div>
								</div>
								<!-- /widget-body -->
							</div>
							<!-- /signup-box -->
						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>

	</div>
	<!-- /widget-body -->
	</div>
	<!-- /signup-box -->
	</div>
	<!-- /position-relative -->
	</div>
	</div>
	<!-- /.col -->
	</div>
	<!-- /.row -->
	</div>
	</div>

	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='uiresources/assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='uiresources/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='uiresources/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>

	<!-- inline scripts related to this page -->

	<script type="text/javascript">
		function show_box(id) {
			jQuery('.widget-box.visible').removeClass('visible');
			jQuery('#' + id).addClass('visible');
		}

		function registerUser() {
			console.log('checkbox');
			console.log(document.getElementById("agreement").checked);
			var validationFlag = true;
			if (document.getElementById("regEmail").value.trim() == "") {
				document.getElementById("regEmail").focus();
				validationFlag = false;
			} else if (document.getElementById("regUsername").value.trim() == "") {
				document.getElementById("regUsername").focus();
				validationFlag = false;
			} else if (document.getElementById("regPassword").value.trim() == "") {
				document.getElementById("regPassword").focus();
				validationFlag = false;
			} else if (document.getElementById("regRepeatPassword").value
					.trim() == "") {
				document.getElementById("regRepeatPassword").focus();
				validationFlag = false;
			} else if (document.getElementById("regPassword").value.trim() != document
					.getElementById("regRepeatPassword").value.trim()) {
				alert("password doesn't match");
				validationFlag = false;
			}
			else if (!document.getElementById("agreement").checked) {
				alert("please accept the user agreement");
				validationFlag = false;
			}
			console.log('validationFlag');
			console.log(validationFlag);
			//registrationForm
			if (validationFlag) {
				document.getElementById("registrationForm").method = "post";
				document.getElementById("registrationForm").action = "register";
				document.getElementById("registrationForm").submit();
			}

		}
		//show_box('signup-box');
	</script>
	<c:if test="${not empty duplicateUSer}">
	<script>
	show_box('signup-box');
	</script>
	</c:if>
</body>
</html>
