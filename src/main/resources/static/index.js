/*alert which is used to display a message to the user when the page is loaded*/
//alert("Hello, welcome to the Spring Boot Web Application!");

var users = [
    {
        "image": "/images/jane.png",
        "name": "Jane Doe",
        "profession": "Software Engineer"
    },
    {
        "image": "/images/john.png",
        "name": "John Doe",
        "profession": "Data Engineer"
    }

];

var id = 0;

function toggleUser() {
    id = (id + 1) % users.length;

    var userImage = document.getElementById("user-image");
    var userName = document.getElementById("user-name");
    var userProfession = document.getElementById("user-profession ");

    userImage.src = users[id].image;
    userName.textContent = users[id].name;
    userProfession.textContent = users[id].gender;
}