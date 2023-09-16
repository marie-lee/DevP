<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@include file="sidebar.jsp" %>--%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/wbs.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.14.3/xlsx.full.min.js"></script>
    <script>
        function excelExport(event) {
            excelExportCommon(event, handleExcelDataAll);
        }

        function excelExportCommon(event, callback) {
            var input = event.target;
            var reader = new FileReader();
            reader.onload = function () {
                var fileData = reader.result;
                var wb = XLSX.read(fileData, {type: 'binary'});
                var sheetNameList = wb.SheetNames;
                var firstSheetName = sheetNameList[0];
                var firstSheet = wb.Sheets[firstSheetName];
                callback(firstSheet);
            };
            reader.readAsBinaryString(input.files[0]);
        }

        function handleExcelDataAll(sheet) {
            handleExcelDataHtml(sheet); // html 형태
        }

        function handleExcelDataHtml(sheet) {
            $("#displayExcelHtml").html(XLSX.utils.sheet_to_html(sheet));
        }

        // 출처 : https://github.com/SheetJS/js-xlsx/issues/214
        function get_header_row(sheet) {
            var headers = [];
            var range = XLSX.utils.decode_range(sheet['!ref']);
            var C, R = range.s.r; /* start in the first row */
            /* walk every column in the range */
            for (C = range.s.c; C <= range.e.c; ++C) {
                var cell = sheet[XLSX.utils.encode_cell({c: C, r: R})]

                var hdr = "UNKNOWN " + C;
                if (cell && cell.t) hdr = XLSX.utils.format_cell(cell);

                headers.push(hdr);
            }
            return headers;
        }
    </script>
</head>
<body>
    <div class="container">
<%--        <div class="main-text">일정 및 업무 수정</div>--%>
<%--        <div class="mt-5 ml-4">--%>
        <div>
            파일 선택 : <input type="file" id="excelFile" onchange="excelExport(event)"/>
<%--            <h1>HTML 형태로 보기</h1>--%>
            <div id="displayExcelHtml"></div>
        </div>
    </div>
</body>
</html>