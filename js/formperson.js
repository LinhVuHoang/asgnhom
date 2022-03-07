document.addEventListener('DOMContentLoaded',function (){
    var btnSubmit = document.getElementById("btn-submit");
    var txtName = document.forms['person-form']['name'];
    var txtAddress = document.forms['person-form']['address'];
    var txtMobilephone = document.forms['person-form']['mobilephone'];
    var txtCmnd = document.forms['person-form']['cmnd'];
    var txtBudget= document.forms['person-form']['budget'];
    var btnsubmit = document.getElementById("btn-submit");
    btnsubmit.onclick = function () {
        var name = txtName.value;
        var address = txtAddress.value;
        var mobilephone = txtMobilephone.value;
        var cmnd = txtCmnd.value;
        var budget = txtBudget.value;

        var dataToSend = {
            "name": name,
            "address":address,
            "mobilephone":mobilephone,
            "cmnd":cmnd,
            "budget":budget
        }
        var xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.onreadystatechange = function () {
            //kiểm tra khi trạng thái request đã hoàn thành và thành công(status =200) hoặc thất bại (404,500...)
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 201) {
                alert('Create new person success!');
                window.location.href = "/asgnhom/personlist.html";
            }else if(xmlHttpRequest.status != 201) {
                alert('Create new person failed!');
                window.location.href = "/asgnhom/personlist.html";
            }
        }
        xmlHttpRequest.open('post','http://localhost:8080/api/v1/persons',false)
        xmlHttpRequest.setRequestHeader('Content-Type','application/json');
        xmlHttpRequest.send(JSON.stringify(dataToSend));
    }
})