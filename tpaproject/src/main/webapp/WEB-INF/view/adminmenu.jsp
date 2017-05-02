<a class="menu-toggler" id="menu-toggler" href="#"> <span
	class="menu-text"></span>
</a>
<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
		} catch (e) {
		}
	</script>



	<ul class="nav nav-list">


		<li <c:if  test="${pageName=='dashBoard'}"> class="active" </c:if>>
			<a href="home"> <i class="icon-dashboard"></i> <span
				class="menu-text"> Dashboard </span>
		</a>
		</li>


		<security:authorize access="hasAnyRole('ROLE_USER')">
			<li><a href="fileUpload" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Upload File				
			</a></li>
						<li><a href="cloudFilesList" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Cloud Files				
			</a></li>
						<li><a href="sharedFilesList" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Shared Data				
			</a></li>
						<li><a href="userRequestedFile" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Get Requested Files				
			</a></li>
			
</a></li>
						<li><a href="userDetails" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> My details			
			</a></li>
		</security:authorize>
		
		<security:authorize access="hasAnyRole('ROLE_ADMIN')">
			<li><a href="usersList" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> View User				
			</a></li>
						<li><a href="allUserFilesList" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> User Files				
			</a></li>
						<li><a href="adminRequestedFilesList" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> File Requests				
			</a></li>
						<li><a href="userTransactions" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Users Transactions				
			</a></li>
			<li><a href="adminStatistics" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Statistics				
			</a></li>

		</security:authorize>
		
		
			<security:authorize access="hasAnyRole('ROLE_TPA')">
			<li><a href="tpaRequestedFilesList" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> File Requests				
			</a></li>
						<li><a href="allUserFilesList" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Deployed Files				
			</a></li>
					</a></li>
						<li><a href="tpaHashkey" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> User Random key				
			</a></li>
			<li><a href="tpaStatistics" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Statistics				
			</a></li>		
			

		</security:authorize>

	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>