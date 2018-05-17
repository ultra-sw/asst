document.getElementById("navLoginButton").disabled = true;
document.getElementById("navLoginButton").value="omg";
function navLoginButtonLocker(){
    var logCheck="";
    var passCheck="";

    logCheck = document.getElementById("navLoginInput").value;
    passCheck = document.getElementById("navPasswordInput").value;

    if(logCheck != "" && passCheck != ""){
        document.getElementById("navLoginButton").disabled = false;
    }else{
        document.getElementById("navLoginButton").disabled = true;
    }
}