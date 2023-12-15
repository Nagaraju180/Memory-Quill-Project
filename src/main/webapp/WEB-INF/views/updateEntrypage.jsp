<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Entry - My Diary</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background: linear-gradient(to right, #f06, #9f6);
    }

    header {
     background: linear-gradient(to right, #f06, #9f6);
      color: white;
      padding: 10px;
      text-align: center;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    section {
      margin: 20px;
      padding: 20px;
      background-color: #fff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    form {
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    label {
      margin-bottom: 10px;
    }

    input, textarea {
      width: 100%;
      padding: 8px;
      margin-bottom: 15px;
      box-sizing: border-box;
    }

    button {
      padding: 8px;
      background-color: #4caf50; /* Green button color */
      color: white;
      border: none;
      cursor: pointer;
    }

    button:hover {
      background-color: #45a049; /* Darker green on hover */
    }

  </style>
</head>
<body>

  <header>
    <h1>Update Entry - My Diary</h1>
  </header>

  <section>
    <form action="./updateentryInDB" method="post">
       
      <label>Date</label> 
         <input type="text" name="entrydate" class="formcontrol" value="<fmt:formatDate value="${entry.entrydate}" pattern="yyyy-MM-dd"/>"  readonly><br/>
      <label>Description</label> 
        <textarea id="discription" name="discription" rows="4" >${entry.discription}</textarea>
        <input type="hidden" name="userid" value="${user.id}">
        <input type="hidden" name="id" value="${entry.id}">

        <button type="submit">Update</button>
    </form>
  </section>

</body>
</html>
