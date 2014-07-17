<%-- 
    Document   : eqation_finder
    Created on : Mar 9, 2014, 10:12:09 PM
    Author     : Administrator
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="varlist" class="java.util.LinkedList<PhysicsCalc.Var>" scope="request"/>

<!DOCTYPE html>
<html>
  <head>
      <SCRIPT language="javascript">
         function addRow(tableID) {
 
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
 
            var colCount = table.rows[0].cells.length;
 
            for(var i=0; i<colCount; i++) {
                var newcell = row.insertCell(i);
                newcell.innerHTML = table.rows[0].cells[i].innerHTML;
                //alert(newcell.childNodes);
                switch(newcell.childNodes[0].type) {
                    case "text":
                            newcell.childNodes[0].value = "";
                            break;
                    case "checkbox":
                            newcell.childNodes[0].checked = false;
                            break;
                    case "select-one":
                            newcell.childNodes[0].selectedIndex = 0;
                            break;
                }
            }
         }
 
         function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    if(rowCount <= 1) {
                        alert("Cannot delete all the rows.");
                        break;
                    }
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
        }
    </SCRIPT>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search For An Equation</title>
</head>
<body>
 
    <input type="button" value="Add Row" onclick="addRow('varTable')" />
 
    <input type="button" value="Delete Row" onclick="deleteRow('varTable')" />
    
    <form action="FindEquations" method="post" >
    <table id="varTable" width="750x" border="1">
        <TR>
            <TD><input type="checkbox" name="checkbox"/></TD>
            <TD>
                <SELECT name="varparams" multiple>
                <c:forEach var="item" items="${varlist}">
                    <OPTION value="${item.id}">Symbol: ${item.symbol} &nbsp&nbsp&nbsp&nbsp&nbsp  Unit: ${item.unit})</OPTION>
                </c:forEach>
            </TD>
        </TR>
    </table>
    <input type="submit" name="Submit" value="Search" />
    </form>
        
 
</body>
</html>
