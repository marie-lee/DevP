
var colData = [
    { label: "Category", name: "category" },
    { label: "Work Package", name: "workPackage" },
    { label: "depth", name: "depth" },
    { label: "detail", name: "detail" },
    { label: "상태", name: "status" },
    { label: "담당자", name: "responsibility" },
    { label: "시작일", name: "startDate" },
    { label: "종료일", name: "endDate" }
];
$(document).ready(function(){
    var table = document.getElementById("taskTbl");
    var colCount = 0;
    if (table){
        var headerRow = table.querySelector("thead tr");
        if(headerRow){
            colCount = headerRow.cells.length;
            cols = colCount
        }
    }
    console.log(colCount);
});


function add_depth(){
    const table = document.getElementById('taskTbl');

    const newRow = table.insertRow();   // 행 추가

    // 각 셀에 데이터 추가
    for (let i = 0; i < cols; i++) {
        const newCell = newRow.insertCell(i);

        const inputElement = document.createElement('input');
        inputElement.className = 'form-control';

        if (colData[i].name === "category"){
            const selectElement = document.createElement('select');
            selectElement.className = 'form-select';
            selectElement.name = colData[i].name+'['+i+1+']';

            const option = document.createElement('option');
            option.value = "";
            option.text = "선택";
            option.disabled = true;
            option.selected = true;

            selectElement.appendChild(option);

            for (const category of categoryArray){
                const option = document.createElement('option');
                option.value = category;
                option.text = category;
                selectElement.appendChild(option);
            }
            newCell.appendChild(selectElement);
        } else {
            if(colData[i].name === "startDate" || colData[i].name === "endDate"){
                inputElement.type = 'date';
                inputElement.setAttribute('min',getCurrentDate());
                inputElement.setAttribute('value',getCurrentDate());
            } else {
                inputElement.type = 'text';
            }

            inputElement.name = colData[i].name+'['+i+1+']';
            newCell.appendChild(inputElement);
        }

        console.log(i+1+"번째 열 추가됨");

    }

    console.log("행 추가됨");
}

    function delete_depth(){
        const table = document.getElementById('taskTbl');
        for(let i = 0; i<table.rows.length;i++){
            table.rows[i].deleteCell(-1);
        }
    }



function deleteTask(taskId){
    if(confirm("업무를 삭제하시겠습니까?")){
        $.ajax({
            type: 'POST',
            url: '/leader/task/delete.do',
            data: {
                taskId: taskId
            },
            success: function(response){
                alert("삭제되었습니다");
                window.location.href="/leader/task/view.do";
            },
            error: function(error){
                console.log("에러: "+error);
            }
        });
    }
}

