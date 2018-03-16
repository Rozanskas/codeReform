$(document).ready(function () {
	 
	$("#inputFile1").change(function(e){
	        readURL(this,e);
	    });
	 $("#inputFile2").change(function(e){
	        readURL2(this,e);
	    });
    setOnClickListeners();
});

var c1=0;
var c2=0;
var fileNameArray=[];
var contentArray=[];
var ci1=0;
var ci2=0;
var fileNameArray2=[];
var contentArray2=[];

function getLastIndex(str) {
    return str.toString().indexOf('.') + 3;
}
   
function readURL(input,e) {
	var fileName=e.target.files[0].name;
	$("#showing1").text("Showing content of file "+ fileName);
	
	for(j=0;j<input.files.length;j++){
		fileNameArray[c2]=e.target.files[j].name;
		c2++;
	}
	for(i=0;i<input.files.length;i++){
		
		var reader = new FileReader();
		reader.readAsText(input.files[i]);
		
    	reader.onload = function (e) {
    		contentArray[c1]=e.target.result;
    
    	                
		var r= $('<input id="upButon'+c1+'" style="margin-left:20px;margin-bottom:5px;" type="button" value="'+ fileNameArray[c1]+'"/>');
		
        $("#below_text1").append(r);
       
        
        
        $("#upButon"+c1).click(function(){
        	
        	var id = $(this).attr('id').replace(/upButon/, '');
        	document.getElementById("crDocument1").value = contentArray[id];
        	$("#showing1").text("Showing content of file "+fileNameArray[id]);
        	
        	
        	
        });
        
        c1++;
	}
    	
	}
	
	
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
       document.getElementById("crDocument1").value = e.target.result;
        
        }
        reader.readAsText(input.files[0]);
    }
    
}
function readURL2(input,e) {
	
	var fileName=e.target.files[0].name;
	$("#showing2").text("Showing content of file "+ fileName);
	
	for(j=0;j<input.files.length;j++){
		fileNameArray2[ci2]=e.target.files[j].name;
		ci2++;
	}
	for(i=0;i<input.files.length;i++){
		
		var reader = new FileReader();
		reader.readAsText(input.files[i]);
		
    	reader.onload = function (e) {
    		contentArray2[ci1]=e.target.result;
    
    	                
		var r= $('<input id="upButonn'+ci1+'" style="margin-left:20px;margin-bottom:5px;" type="button" value="'+ fileNameArray2[ci1]+'"/>');
		
        $("#below_text2").append(r);
       
        
        
        $("#upButonn"+ci1).click(function(){
        	
        	var id = $(this).attr('id').replace(/upButonn/, '');
        	document.getElementById("crDocument2").value = contentArray2[id];
        	$("#showing2").text("Showing content of file "+fileNameArray2[id]);
        	
        	
        	
        });
        
        ci1++;
	}
    	
	}
	
	
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        
        reader.onload = function (e) {
       document.getElementById("crDocument2").value = e.target.result;
        
        }
        reader.readAsText(input.files[0]);
    }
    
}

function setOnClickListeners() {
    $('#bSubmit1').click(function (event) {
    	event.preventDefault();
    	
    	var document = {
            content: $('#crDocument1').val()
        };
    	
        $.ajax({
            url: 'http://localhost:8087/api/analyze',
            method: 'POST',
            data: JSON.stringify(document),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (response) {
                response.volume = response.volume.toString().substring(0, getLastIndex(response.volume));
                response.effort = response.effort.toString().substr(0, getLastIndex(response.effort))
                response.timeRequiredToProgram = response.timeRequiredToProgram.toString()
                                                    .substr(0, getLastIndex(response.timeRequiredToProgram));
                response.numberDeliveredBugs = response.numberDeliveredBugs.toString()
                                                    .substr(0, getLastIndex(response.numberDeliveredBugs));

                $('#re1_1').text('Number of Lines: ' + response.numberLines );
                $('#re1_2').text('Program Length: ' + response.length  );
                $('#re1_3').text('Vocabulary: ' + response.vocabulary );
                $('#re1_4').text('Calculated Length: ' + response.calculatedLength );
                $('#re1_5').text('Volume: ' + response.volume );
                $('#re1_6').text('Difficulty: ' + response.difficulty );
                $('#re1_7').text('Effort: ' + response.effort );
                $('#re1_8').text('Time Required to Program: ' + response.timeRequiredToProgram);
                $('#re1_9').text('Number of Delivered Bugs: ' + response.numberDeliveredBugs );
                $('#saveFile1').css("display", "block");
            },
            error: function (error) {
                console.log(error.responseJSON);
            }
        });
    });
    
    $('#bSubmit2').click(function () {
    	event.preventDefault();
        var document = {
            content: $('#crDocument2').val()
        };
        $.ajax({
            url: 'http://localhost:8087/api/analyze',
            method: 'POST',
            data: JSON.stringify(document),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (response) {
                response.volume = response.volume.toString().substring(0, getLastIndex(response.volume));
                response.effort = response.effort.toString().substr(0, getLastIndex(response.effort))
                response.timeRequiredToProgram = response.timeRequiredToProgram.toString()
                    .substr(0, getLastIndex(response.timeRequiredToProgram));
                response.numberDeliveredBugs = response.numberDeliveredBugs.toString()
                    .substr(0, getLastIndex(response.numberDeliveredBugs));

                $('#re2_1').text('Number of Lines: ' + response.numberLines );
                $('#re2_2').text('Program Length: ' + response.length  );
                $('#re2_3').text('Vocabulary: ' + response.vocabulary );
                $('#re2_4').text('Calculated Length: ' + response.calculatedLength );
                $('#re2_5').text('Volume: ' + response.volume );
                $('#re2_6').text('Difficulty: ' + response.difficulty );
                $('#re2_7').text('Effort: ' + response.effort );
                $('#re2_8').text('Time Required to Program: ' + response.timeRequiredToProgram);
                $('#re2_9').text('Number of Delivered Bugs: ' + response.numberDeliveredBugs );
                $('#saveFile2').css("display", "block");
            },
            error: function (error) {
                console.log(error.responseJSON);
            }
        });
    });
    $('#bCompare').click(function () {
    	
    	 for (var i=0; i<9; i++) {
    		
    		 
    	        var value1 = Number($('#re1_'+(i+1)).text().split(':')[1].trim());
    	        var value2 = Number($('#re2_'+(i+1)).text().split(':')[1].trim());
    	       
    	        
    	        if (value1 < value2) {
    	            // val1 green val2 red
    	        	$('#re1_'+(i+1)).css("background-color", "#7ffc79");
    	        	$('#re2_'+(i+1)).css("background-color", "#FB4E4E");
    	        } else if (value1 === value2) {
    	        	$('#re1_'+(i+1)).css("background-color", "#59a1ff");
    	        	$('#re2_'+(i+1)).css("background-color", "#59a1ff");
    	        } else {
    	        	$('#re1_'+(i+1)).css("background-color", "#FB4E4E");
    	        	$('#re2_'+(i+1)).css("background-color", "#7ffc79");
    	        }
    	    }
    });
    
    $("#btn-save1").click( function() {
    	var text ="";
    	for(i=1;i<10;i++){
    		var text = text + $("#re1_"+i).text()+ '\n';
    		
    	}
    	  
    	  var filename = $("#fileName1").val();
    	  var blob = new Blob([text], {type: "text/plain;charset=utf-8"});
    	  saveAs(blob, filename+".rtf");
    	});
    $("#btn-save2").click( function() {
    	var text ="";
    	for(i=1;i<10;i++){
    		var text = text + $("#re2_"+i).text()+ '\n';
    		
    	}
    	  
    	  var filename = $("#fileName2").val();
    	  var blob = new Blob([text], {type: "text/plain;charset=utf-8"});
    	  saveAs(blob, filename+".rtf");
    	});
    
}