function getFields()
{
	var selec=new Array();
	var selecval=new Array();
	var valu="";
	var text="";
	var tes=["Hi","Hello","Good","Morning","Afternoon"];
	var sel1=document.getElementById("test-1");
	var sel2=document.getElementById("test-2");
	var sel3=document.getElementById("test-3");
	var len1=document.getElementById("test-1").length;
	var len2=document.getElementById("test-2").length;
	var len3=document.getElementById("test-3").length;
	for(var i=0;i<len1;i++)
	{
		if(sel1.options[i].selected)
		{
			selec.push(sel1.options[i].text);	
		}
	}
	for(var i=0;i<len2;i++)
	{
		if(sel2.options[i].selected)
		{
			selec.push(sel2.options[i].text);	
		}
	}
	for(var i=0;i<len3;i++)
	{
		if(sel3.options[i].selected)
		{
			selec.push(sel3.options[i].text);	
		}
	}
	for(var i=0;i<len3;i++)
	{
		if(sel3.options[i].selected)
		{
			selecval.push(sel3.options[i].value);
		}
	}
	for(var i=0;i<selecval.length;i++)
	{
		valu +=selecval[i]+",";
	}
	for(var i=0;i<selec.length;i++)
	{
		text +=selec[i]+",";
	}
	document.getElementById('selection').value=valu;
	document.getElementById('selectext').value=text;
}



$(function(){

	$("#test-1").multiselect({
		show: ["slide", 300],
		hide: ["drop", 500]
	}).multiselectfilter();

	$("#test-2").multiselect({
		show: ["slide", 300],
		hide: ["drop", 500]
	}).multiselectfilter();

	$("#test-3").multiselect({
		show: ["slide", 300],
		hide: ["drop", 500]
	}).multiselectfilter();
	});