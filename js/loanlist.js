document.addEventListener('DOMContentLoaded',function (){


    var tableBody = document.getElementById('my-table-data1');
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function (){
        if(xmlHttpRequest.readyState ==4 && xmlHttpRequest.status ==200){
            var data = JSON.parse(xmlHttpRequest.responseText);
            var newcontent ='';
            for(let i =0;i<data.length;i++){
                var money = (data[i].loanamount/data[i].periodmonth)+((data[i].loanamount*data[i].rate)/data[i].periodmonth);
                if(data[i].status==1) {
                    newcontent += `<tr>
<td>${data[i].person.id}</td>
<td>${data[i].person.name}</td>
<td>${data[i].loanamount}</td>
<td>${data[i].periodmonth}</td>
<td>${data[i].rate}%</td>
<td>${money}</td>
<td style="color: aqua">Đã phê duyệt</td>
</tr>
`;
                }else{
                    newcontent += `<tr>
<td>${data[i].person.id}</td>
<td>${data[i].person.name}</td>
<td>${data[i].loanamount}</td>
<td>${data[i].periodmonth}</td>
<td>${data[i].rate}%</td>
<td>${money}</td>
<td style="color: red">Bị từ chối</td>
</tr>
`;
                }
            }
            tableBody.innerHTML = newcontent;
        }
    }
    xmlHttpRequest.open('get','http://localhost:8080/api/v1/loans',false)
    xmlHttpRequest.send();
})