

$(document).ready(function() {
   $("#state").change(function() {
      var stateid = $(this).val();
      var urlString="/getDistrict/id";
      var s = '<option value=' + -1 + '>SELECT</option>';
      if (stateid > 0) {
      	$.ajax({
        url : urlString,
        data : { "stateid" : stateid },
        contentType: "application/json; charset=utf-8",
        type:"POST",
         dataType: "json",
        success : function(result) {
        	var result = JSON.parse(result);
        	for (var i = 0; i < re.length; i++) {
        	  s += '<option value="' + result[i].stateid + '">'+ result[i].statename+ '</option>';
        	}
        	$('#dist').html(s);
        }
      });
     }
     //reset data
     $('#dist').html(s);
     $('#city').html(s);

   });
   
   
   
   
   
   });
   
   
   
   