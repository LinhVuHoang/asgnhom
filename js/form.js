document.addEventListener('DOMContentLoaded',function (){
    var btnSubmit = document.getElementById("btn-submit");
    var txtLoanamount = document.forms['loan-form']['loanamount'];
    var txtPeriodmonth = document.forms['loan-form']['periodmonth'];
    var txtRate = document.forms['loan-form']['rate'];
    var txtPerson= document.forms['loan-form']['person'];
    var txtStatus = document.forms['loan-form']['status'];
    var btnsubmit = document.getElementById("btn-submit");
    btnsubmit.onclick = function () {
        var loanamount = txtLoanamount.value;
        var periodmonth = txtPeriodmonth.value;
        var rate = txtRate.value;
        var person = txtPerson.value;
        var status = txtStatus.value;
        var dataToSend = {
            "loanamount":loanamount,
            "periodmonth":periodmonth,
            "rate":rate,
            "status":status,
            "person":{
                "id":person,
                "name":"",
                "address":"",
                "mobile":"",
                "cmnd":"",
                "budget":""
            },

        }
        var xmlHttpRequest = new XMLHttpRequest();
        xmlHttpRequest.onreadystatechange = function () {
            //kiểm tra khi trạng thái request đã hoàn thành và thành công(status =200) hoặc thất bại (404,500...)
            if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 201) {
                alert('Create new loan success!');
                window.location.href = "/asgnhom/loanlist.html";
            }
        }
        xmlHttpRequest.open('post','http://localhost:8080/api/v1/loans',false)
        xmlHttpRequest.setRequestHeader('Content-Type','application/json');
        xmlHttpRequest.send(JSON.stringify(dataToSend));
    }
})