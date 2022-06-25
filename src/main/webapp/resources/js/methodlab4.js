function get_values(){
    inputR = document.getElementById("requestForm:R_input").value;
    inputX = document.getElementById("requestForm:X_input").value
    inputX = inputX.replace(/,/,".");
    inputR = inputR.replace(/,/,".");
    inputR = Number(inputR).toFixed(2)+"";
    inputX = Number(inputX).toFixed(2)+"";
    inputY = "";
    if(document.getElementById("requestForm:Y").value!==null &&document.getElementById("requestForm:Y").value!=="") {
        inputY = document.getElementById("requestForm:Y").value;
        inputY = inputY.replace(/,/,".");
        inputY = Number(document.getElementById("requestForm:Y").value).toFixed(2) + "";
    }else {
        inputY = 10000;
    }
    document.getElementById("checkForm:checkX").value = inputX;
    document.getElementById("checkForm:checkR").value = inputR;
    document.getElementById("checkForm:checkY").value = inputY;
}
function check_repeat(){
    repeated = document.getElementById("checkForm:checkBasic").value;
    if(repeated){
        alert("You input 3 dot not in range")
    }
}