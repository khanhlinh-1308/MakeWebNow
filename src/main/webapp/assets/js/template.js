const searchInput = document.getElementById("searchInput");

searchInput.addEventListener("keyup", function () {

    let keyword = this.value.toLowerCase();

    let items = document.querySelectorAll(".template-item");

    items.forEach(item => {

        let name = item.querySelector(".template-name")
                       .innerText
                       .toLowerCase();

        if (name.includes(keyword)) {

            item.style.display = "";

        } else {

            item.style.display = "none";

        }

    });

});