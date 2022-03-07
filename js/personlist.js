document.addEventListener('DOMContentLoaded',function (){


    var tableBody = document.getElementById('my-table-data');
    var xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.onreadystatechange = function (){
        if(xmlHttpRequest.readyState ==4 && xmlHttpRequest.status ==200){
            var data = JSON.parse(xmlHttpRequest.responseText);
            var newcontent ='';
            for(let i =0;i<data.length;i++){
                newcontent +=`<tr>
<td>${data[i].id}</td>
<td>${data[i].name}</td>
<td>${data[i].address}</td>
<td>+84${data[i].mobilephone}</td>
<td>${data[i].cmnd}</td>
<td>${data[i].budget}</td>
</tr>
`;
            }
            tableBody.innerHTML = newcontent;
        }
    }
    xmlHttpRequest.open('get','http://localhost:8080/api/v1/persons',false)
    xmlHttpRequest.send();
})