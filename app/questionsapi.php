<?php

// Creating the connection
$conn = mysqli_connect("localhost", "root", "", "quiz_db");

// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

// Preparing the query
$stmt = $conn->prepare("SELECT `question`, `option1`, `option2`, `option3`, `option4`, `correct_option` FROM `math_quiz`");

// Executing the query
$stmt->execute();

// Binding the result to variables
$stmt->bind_result($question, $option1, $option2, $option3, $option4, $correct_option);

// Creating an empty array
$questions_array = array();

// Traversing through all the questions
while ($stmt->fetch()) {
    $temp = array();
    $temp['question'] = $question;
    $temp['option1'] = $option1;
    $temp['option2'] = $option2;
    $temp['option3'] = $option3;
    $temp['option4'] = $option4;
    $temp['correct_option'] = $correct_option;

    array_push($questions_array, $temp);
}

// Displaying the result in JSON format
echo json_encode($questions_array);

// Close connection and statement
$stmt->close();
$conn->close();

?>
