<html>
<body>

<h2>Finding HTML Elements by Id</h2>

<p id="intro">Hello World!</p>
<p>This example demonstrates the <b>getElementsById</b> method.</p>

<p id="demo"></p>

<script>
var myElement = document.getElementById("intro");
document.getElementById("demo").innerHTML =
"The text from the intro paragraph is " + myElement.innerHTML;
</script>

</body>
</html>