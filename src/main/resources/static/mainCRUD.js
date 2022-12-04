function clickHandler(ths){
 if(ths.value=="+"){
 ths.value="add";
  insRow();
 }else{
    var table= document.getElementById('table');
    ths.value="+";
     var tds= table.rows[ table.rows.length - 1 ].querySelectorAll('td')
     var json = {
         ID_R: tds[0].firstChild.value,
         ID: tds[1].firstChild.value,
         TYPE: tds[2].firstChild.value,
         SECTIONNAME:tds[3].firstChild.value,
         TITLE: tds[4].firstChild.value,
         SDATE: tds[5].firstChild.value,
     };
     console.log(json)
     fetch('/insert', {
         method: 'post',
         headers: {
             'Accept': 'application/json, text/plain, */*',
             'Content-Type': 'application/json'
         },
         body:  JSON.stringify(json)
     }).then(function (response) {
         if (response.ok) {
             for (var i = 0; i < tds.length; i++) {
                 tds[i].innerHTML=tds[i].firstChild.value;
                 tds[i].align="center";
             }
             alert("Good: ");
         } else {
             response.text().then((body) => {
                 alert("ERROR: "  +"\n"+body);
             });
         }
     })
 }
}
function insRow()
{
    var x=document.getElementById('table');
    let row_3 = document.createElement('tr');
    let row_3_data_1 = document.createElement('td');
    let row_3_input_1 = document.createElement('input');
    row_3_data_1.appendChild(row_3_input_1);
    let row_3_data_2 = document.createElement('td');
    let row_3_input_2 = document.createElement('input');
    row_3_data_2.appendChild(row_3_input_2);
    let row_3_data_3 = document.createElement('td');
    let row_3_input_3 = document.createElement('input');
    row_3_data_3.appendChild(row_3_input_3);
    let row_3_data_4 = document.createElement('td');
    let row_3_input_4 = document.createElement('input');
    row_3_data_4.appendChild(row_3_input_4);
    let row_3_data_5 = document.createElement('td');
    let row_3_input_5 = document.createElement('input');
    row_3_data_5.appendChild(row_3_input_5);
    let row_3_data_6 = document.createElement('td');
    let row_3_input_6 = document.createElement('input');
    row_3_data_6.appendChild(row_3_input_6);

    row_3.appendChild(row_3_data_1);
    row_3.appendChild(row_3_data_2);
    row_3.appendChild(row_3_data_3);
    row_3.appendChild(row_3_data_4);
    row_3.appendChild(row_3_data_5);
    row_3.appendChild(row_3_data_6);
    x.appendChild(row_3);
}

function delete_row(cell){
    var id= cell.parentNode.querySelectorAll('td')[0].innerText;
    console.log(id);
    var data= cell.parentNode.querySelectorAll('td');
    var json = {
        ID_R: data[0].innerText,
        ID: data[1].innerText,
        TYPE: data[2].innerText,
        SECTIONNAME: data[3].innerText,
        TITLE: data[4].innerText,
        SDATE: data[5].innerText,
    };
    fetch('/delete', {
        method: 'post',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body:  JSON.stringify(json)
    }).then(function (response) {
        if(response.ok){
            alert("Good: ");
            var table = document.getElementById('table');
            table.deleteRow(cell.parentNode.rowIndex);
        }else{
            response.text().then((body) => {
                alert("ERROR: "  +"\n"+body);
            });
        }
    })
}

function table_click(){
    var box = document.getElementById('del_box');
    let cell = event.target;
    if(box.checked){
        delete_row(cell);
    }
    else {
    if (cell.tagName.toLowerCase() != 'td')
        return;

    var lastVal=cell.innerText;
    var lastID=cell.parentNode.querySelectorAll('td')[0].innerText;
    var input = document.createElement('input');
    input.value = cell.innerHTML;
    cell.innerHTML = '';
    cell.appendChild(input);
    input.focus();
    input.select();

    input.addEventListener('blur',function (){
        cell.innerHTML = this.value;
    })

    input.addEventListener('change',function () {
        var data= cell.parentNode.querySelectorAll('td');
        cell.innerHTML = this.value;
        var json = {
            ID_R: data[0].innerText,
            ID: data[1].innerText,
            TYPE: data[2].innerText,
            SECTIONNAME: data[3].innerText,
            TITLE: data[4].innerText,
            SDATE: data[5].innerText,
            LAST_ID: lastID
        };
        fetch('/update', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body:  JSON.stringify(json)
        }).then(function (response) {
            if(response.ok){
                alert("Good: ");
            }else{
                cell.innerHTML = lastVal;
                response.text().then((body) => {
                    alert("ERROR: "  +"\n"+body);
                });
            }
        })
    })}
}