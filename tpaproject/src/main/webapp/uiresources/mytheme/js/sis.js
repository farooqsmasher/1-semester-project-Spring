/*
 * *****************************************************************************
 * *****************************************************************************
 * ***********************STUDENT INFORMATION SYSTEM****************************
 * *****************************************************************************
 * *****************************************************************************
 * *****************************************************************************
 * */

//Script For Changing the Color Of A table Header Dynamically
			colors = new Array('#330099', '#660033', '#669933', '#FFFF00', '#996633', '#FF0066');
            function annoyingEffectOnDiv(tic, divId){
                tic %= colors.length;
                divVar = document.getElementById(divId);
                divVar.style.color = colors[tic];
                setTimeout("annoyingEffectOnDiv("+(tic+1)+", '"+divId+"')", 3000);
            }
            //****************************************************************
           
            //JQuery Script For table Designing
            
            $(function () {
                $('table').footable().bind('footable_filtering', function (e) {
                  var selected = $('.filter-status').find(':selected').text();
                  if (selected && selected.length > 0) {
                    e.filter += (e.filter && e.filter.length > 0) ? ' ' + selected : selected;
                    e.clear = !e.filter;
                  }
                });

                $('.clear-filter').click(function (e) {
                  e.preventDefault();
                  $('.filter-status').val('');
                  $('table.demo').trigger('footable_clear_filter');
                });

                $('.filter-status').change(function (e) {
                  e.preventDefault();
                  $('table.demo').trigger('footable_filter', {filter: $('#filter').val()});
                });
              });   
            
            //***************************************************************
            
            //Script For Time Table Export Page
            function function_TimeTableExport()
            {
            	var res=form1.exptype.value;
            	var res1=res.toString();
            	if(res1=='pdf')
            	{
            	}
            	else
            		{
            		$('#example').tableExport({type:res,escape:'false'});
            		}
            }
            
            
            //Script For Changing Color in Dashboard
            
        
            
            function dateCompare(time1,time2) {
          	  var t1 = new Date();
          	  var parts = time1.split(":");
          	  t1.setHours(parts[0],parts[1],parts[2],0);
          	  var t2 = new Date();
          	  parts = time2.split(":");
          	  t2.setHours(parts[0],parts[1],parts[2],0);

          	  // returns 1 if greater, -1 if less and 0 if the same
          	  if (t1.getTime()>t2.getTime()) return 1;
          	  if (t1.getTime()<t2.getTime()) return -1;
          	  
          	 
          	  return 0;
          	}

            
            var fsecid="";
            var str="";
            var dd=1;
            var finalstr="";
            
            
            function setTdDay()
            {
 
            
            	 if(form1.ckdate.value=="")
            		 {
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!

var yyyy = today.getFullYear();
if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm} var today = yyyy+'-'+mm+'-'+dd;
document.getElementById("ckdate").value = today;
            		
            		 }
            	 
            	 
            	 
            	 
            	 
            	 
 
           	  var temp = form1.ckdate.value.split('-');
           	  var date = new Date(temp[0], temp[1]-1, temp[2]);
           	 var n=date.toString();
           	  var date1=n.substring(0, 3).toString();
           	  var doastr="";
           	  
           	 
           		  if(date1=="Sun")
           			  {
 
           			doastr="Sunday";
           			  }
           	  if(date1=="Mon")
           		  {
 
           		doastr="Monday";
           		  }
           	  if(date1=="Tue")
           		  {
 
           		doastr="Tuesday";
           		  }
           	  if(date1=="Wed")
           		  {
 
           		doastr="Wednesday";
           		  }
           	  if(date1=="Thu")
       		  {
 
       		doastr="Thursday";
       		  }
           	  if(date1=="Fri")
       		  {
 
       		doastr="Friday";
       		  }
           	  if(date1=="Sat")
       		  {
 
       		doastr="Saturday";
       		  }
           	// alert(doastr);
           	form1.ckdate1.value=doastr;
           	form1.action="${pageContext.request.contextPath}/dashboard/principal/ckBasedOnDate";
     	   form1.submit();
            }
 function setTdDay1()
 {

 
 	 if(form1.ckdate.value=="")
 		 {
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!

var yyyy = today.getFullYear();
if(dd<10){dd='0'+dd} if(mm<10){mm='0'+mm} var today = yyyy+'-'+mm+'-'+dd;
document.getElementById("ckdate").value = today;
 		
 		 }
 	 
 	 
 	 
 	 
 	 
 	 

	  var temp = form1.ckdate.value.split('-');
	  var date = new Date(temp[0], temp[1]-1, temp[2]);
	 var n=date.toString();
	  var date1=n.substring(0, 3).toString();
	  var doastr="";
	  
	 
		  if(date1=="Sun")
			  {

			doastr="Sunday";
			  }
	  if(date1=="Mon")
		  {

		doastr="Monday";
		  }
	  if(date1=="Tue")
		  {

		doastr="Tuesday";
		  }
	  if(date1=="Wed")
		  {

		doastr="Wednesday";
		  }
	  if(date1=="Thu")
	  {

	doastr="Thursday";
	  }
	  if(date1=="Fri")
	  {

	doastr="Friday";
	  }
	  if(date1=="Sat")
	  {

	doastr="Saturday";
	  }
	// alert(doastr);
	form1.ckdate1.value=doastr;
	//form1.action="${pageContext.request.contextPath}/dashboard/principal/ckBasedOnDate";
 //form1.submit();
 }
      