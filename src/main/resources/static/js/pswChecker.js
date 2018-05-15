        document.getElementById("next").disabled = true;
        function checkPasswordMatch() {
            var logCheck ="";
            var pswCheck ="";
            var login = $("#login").val();
            var password = $("#psw").val();
            var confirmPassword = $("#psw2").val();
            pswCheck = document.getElementById("psw").value;
            logCheck = document.getElementById("login").value;

            $(document).ready(function () {
                $("#psw, #psw2").keyup(checkPasswordMatch);
            });
            if (password == "" || confirmPassword == "") {
                $("#divCheckPasswordMatch").html("");
                document.getElementById("divCheckPasswordMatch").style.display = "none";
            }

            if (password != confirmPassword) {
                document.getElementById("divCheckPasswordMatch").style.borderLeft = "3px solid #dc3545";
                document.getElementById("divCheckPasswordMatch").style.display = "block";
                $("#divCheckPasswordMatch").html("Пароль повторён <b>не</b> верно");
                document.getElementById("next").disabled = true;

            } else {
                document.getElementById("divCheckPasswordMatch").style.display = "block";
                document.getElementById("divCheckPasswordMatch").style.borderLeft = "3px solid #28a745";
                $("#divCheckPasswordMatch").html("Пароль повторён верно");
                if ((password == "") || (confirmPassword == "")) {
                    document.getElementById("divCheckPasswordMatch").style.display = "none";
                }

                if((logCheck != "") && (pswCheck != "")){
                document.getElementById("next").disabled = false;
                }else{
                document.getElementById("next").disabled = true;
                }
            }
        }