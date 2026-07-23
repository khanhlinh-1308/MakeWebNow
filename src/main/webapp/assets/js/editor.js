// =====================================================
// MAKE WEB NOW - EDITOR V2
// =====================================================

document.addEventListener("DOMContentLoaded", function () {

    // ==========================
    // COMPONENTS
    // ==========================

    const blockItems = document.querySelectorAll(".block-item");
    const dropArea = document.getElementById("drop-area");

    const textArea = document.querySelector("textarea");

    const colorInputs = document.querySelectorAll(".form-control-color");
    const textColor = colorInputs[0];
    const backgroundColor = colorInputs[1];

    const btnDelete = document.getElementById("btnDelete");
    const btnDuplicate = document.getElementById("btnDuplicate");
    const btnUp = document.getElementById("btnUp");
    const btnDown = document.getElementById("btnDown");
    const btnSave = document.getElementById("btnSave");
    const btnDashboard = document.getElementById("btnDashboard");

    const btnPreview = document.querySelector(".btn-preview");
    const btnDownload = document.querySelector(".btn-download");
	const btnUndo =
	document.getElementById("btnUndo");

	const btnRedo =
	document.getElementById("btnRedo");

    const websiteID = document.getElementById("websiteID");

    // ==========================
    // VARIABLES
    // ==========================

    let currentBlockType = "";
    let selectedBlock = null;
    let hasChanged = false;
	let history = [];
	let historyIndex = -1;
	function saveHistory() {

	    history = history.slice(0, historyIndex + 1);

	    history.push(dropArea.innerHTML);

	    historyIndex++;

	}
	setInterval(function(){

	    if(hasChanged){

	        btnSave.click();

	        console.log("Auto Save...");

	    }

	},30000);

    // ==========================
    // DRAG START
    // ==========================

    blockItems.forEach(item => {

        item.addEventListener("dragstart", function () {

            currentBlockType = this.innerText.trim();

        });

    });

    // ==========================
    // DRAG OVER
    // ==========================

    dropArea.addEventListener("dragover", function (e) {

        e.preventDefault();

    });

    // ==========================
    // DROP
    // ==========================

    dropArea.addEventListener("drop", function (e) {

        e.preventDefault();

        const block = document.createElement("div");

        block.className = "dropped-block";

        switch (currentBlockType) {

            case "Header":

                block.innerHTML =
                    "<h2>Tiêu đề</h2>";

                break;

            case "Text":

                block.innerHTML =
                    "<p>Đây là đoạn văn bản.</p>";

                break;

            case "Button":

                block.innerHTML =
                    "<button class='btn btn-primary'>Button</button>";

                break;

            case "Image":

                block.innerHTML =
                    "<img src='https://placehold.co/350x180' class='img-fluid rounded'>";

                break;

            case "Footer":

                block.innerHTML =
                    "<footer>Footer</footer>";

                break;

            default:
                return;

        }

        block.addEventListener("click", function () {

            selectBlock(this);

        });

        dropArea.appendChild(block);

        hasChanged = true;
		saveHistory();
		document
		.getElementById("saveStatus")
		.innerHTML="● Đang chỉnh sửa";
    });

    // ==========================
    // SELECT BLOCK
    // ==========================

    function selectBlock(block) {

        document.querySelectorAll(".dropped-block")
            .forEach(item => {

                item.style.border =
                    "2px dashed #ffb6d9";

            });

        selectedBlock = block;

        selectedBlock.style.border =
            "3px solid #ff5ca8";

        loadProperty();

    }

    // ==========================
    // LOAD PROPERTY
    // ==========================

    function loadProperty() {

        if (!selectedBlock) return;

        if (selectedBlock.querySelector("h2")) {

            textArea.value =
                selectedBlock.querySelector("h2").innerText;

        }

        else if (selectedBlock.querySelector("p")) {

            textArea.value =
                selectedBlock.querySelector("p").innerText;

        }

        else if (selectedBlock.querySelector("button")) {

            textArea.value =
                selectedBlock.querySelector("button").innerText;

        }

        else if (selectedBlock.querySelector("footer")) {

            textArea.value =
                selectedBlock.querySelector("footer").innerText;

        }

        else {

            textArea.value = "";

        }

    }

    // ==========================
    // EDIT CONTENT
    // ==========================

    textArea.addEventListener("input", function () {

        if (!selectedBlock) return;

        if (selectedBlock.querySelector("h2")) {

            selectedBlock.querySelector("h2").innerText = this.value;

        }

        else if (selectedBlock.querySelector("p")) {

            selectedBlock.querySelector("p").innerText = this.value;

        }

        else if (selectedBlock.querySelector("button")) {

            selectedBlock.querySelector("button").innerText = this.value;

        }

        else if (selectedBlock.querySelector("footer")) {

            selectedBlock.querySelector("footer").innerText = this.value;

        }

        hasChanged = true;
		saveHistory();
		document
		.getElementById("saveStatus")
		.innerHTML="● Đang chỉnh sửa";
    });

    // ==========================
    // TEXT COLOR
    // ==========================

    textColor.addEventListener("input", function () {

        if (!selectedBlock) return;

        selectedBlock.style.color = this.value;

        hasChanged = true;
		saveHistory();
		document
		.getElementById("saveStatus")
		.innerHTML="● Đang chỉnh sửa";
    });

    // ==========================
    // BACKGROUND
    // ==========================

    backgroundColor.addEventListener("input", function () {

        if (!selectedBlock) return;

        selectedBlock.style.backgroundColor = this.value;

        hasChanged = true;
		saveHistory();
		document
		.getElementById("saveStatus")
		.innerHTML="● Đang chỉnh sửa";
    });

    // ==========================
    // DELETE
    // ==========================

    btnDelete.addEventListener("click", function () {

        if (!selectedBlock) return;

        if (!confirm("Xóa Block này?")) return;

        selectedBlock.remove();

        selectedBlock = null;

        textArea.value = "";

        hasChanged = true;
		saveHistory();
		document
		.getElementById("saveStatus")
		.innerHTML="● Đang chỉnh sửa";
    });

    // ==========================
    // DUPLICATE
    // ==========================

    btnDuplicate.addEventListener("click", function () {

        if (!selectedBlock) return;

        const clone = selectedBlock.cloneNode(true);

        clone.addEventListener("click", function () {

            selectBlock(clone);

        });

        dropArea.appendChild(clone);

        selectBlock(clone);

        hasChanged = true;
		saveHistory();
		document
		.getElementById("saveStatus")
		.innerHTML="● Đang chỉnh sửa";
    });
	
	    // ==========================
	    // MOVE UP
	    // ==========================

	    btnUp.addEventListener("click", function () {

	        if (!selectedBlock) return;

	        const prev = selectedBlock.previousElementSibling;

	        if (prev) {

	            dropArea.insertBefore(selectedBlock, prev);

	            hasChanged = true;
				saveHistory();
				document
				.getElementById("saveStatus")
				.innerHTML="● Đang chỉnh sửa";
	        }

	    });

	    // ==========================
	    // MOVE DOWN
	    // ==========================

	    btnDown.addEventListener("click", function () {

	        if (!selectedBlock) return;

	        const next = selectedBlock.nextElementSibling;

	        if (next) {

	            dropArea.insertBefore(next, selectedBlock);

	            hasChanged = true;
				saveHistory();
				document
				.getElementById("saveStatus")
				.innerHTML="● Đang chỉnh sửa";
	        }

	    });

	    // ==========================
	    // SAVE PROJECT
	    // ==========================

	    btnSave.addEventListener("click", function () {

	        const blocks = [];

	        document.querySelectorAll(".dropped-block").forEach(function (block) {

	            let type = "";
	            let text = "";

	            if (block.querySelector("h2")) {

	                type = "Header";
	                text = block.querySelector("h2").innerText;

	            }
	            else if (block.querySelector("p")) {

	                type = "Text";
	                text = block.querySelector("p").innerText;

	            }
	            else if (block.querySelector("button")) {

	                type = "Button";
	                text = block.querySelector("button").innerText;

	            }
	            else if (block.querySelector("img")) {

	                type = "Image";
	                text = block.querySelector("img").src;

	            }
	            else if (block.querySelector("footer")) {

	                type = "Footer";
	                text = block.querySelector("footer").innerText;

	            }

	            blocks.push({

	                type: type,
	                text: text,
	                color: block.style.color,
	                background: block.style.backgroundColor

	            });

	        });

	        fetch("saveProject", {

	            method: "POST",

	            headers: {

	                "Content-Type":
	                    "application/x-www-form-urlencoded"

	            },

	            body:

	                "websiteID=" +
	                encodeURIComponent(websiteID.value) +

	                "&content=" +
	                encodeURIComponent(JSON.stringify(blocks))

	        })

	        .then(response => response.text())

	        .then(function (data) {

	            if (data.trim() === "success") {

	                hasChanged = false;

					document
					.getElementById("saveStatus")
					.innerHTML="✔ Đã lưu";

					hasChanged=false;

	            }

	            else {

	                alert("Lưu thất bại!");

	            }

	        })

	        .catch(function () {

	            alert("Có lỗi khi lưu!");

	        });

	    });

	    // ==========================
	    // HOME
	    // ==========================

	    btnDashboard.addEventListener("click", function (e) {

	        e.preventDefault();

	        if (!hasChanged) {

	            window.location.href = "dashboard";

	            return;

	        }

	        const save = confirm(

	            "Bạn có muốn lưu Project trước khi quay về Trang chủ?"

	        );

	        if (save) {

	            btnSave.click();

	            setTimeout(function () {

	                window.location.href = "dashboard";

	            }, 700);

	        }

	        else {

	            window.location.href = "dashboard";

	        }

	    });

	    // ==========================
	    // PREVIEW
	    // ==========================

		const desktop =
		document.getElementById("btnPreviewDesktop");

		const tablet =
		document.getElementById("btnPreviewTablet");

		const mobile =
		document.getElementById("btnPreviewMobile");

		desktop.addEventListener("click",function(){

		    dropArea.classList.remove(
		        "preview-tablet",
		        "preview-mobile"
		    );

		    dropArea.classList.add(
		        "preview-desktop",
		        "preview-animation"
		    );

		});

		tablet.addEventListener("click",function(){

		    dropArea.classList.remove(
		        "preview-desktop",
		        "preview-mobile"
		    );

		    dropArea.classList.add(
		        "preview-tablet",
		        "preview-animation"
		    );

		});

		mobile.addEventListener("click",function(){

		    dropArea.classList.remove(
		        "preview-desktop",
		        "preview-tablet"
		    );

		    dropArea.classList.add(
		        "preview-mobile",
		        "preview-animation"
		    );

		});

	    // ==========================
	    // DOWNLOAD
	    // ==========================

	    if (btnDownload) {

	        btnDownload.addEventListener("click", function () {

	            alert("Download sẽ được làm ở bước tiếp theo.");

	        });

	    }
		saveHistory();
		// ==========================
		// UNDO/REDO
		// ==========================

		function bindBlocks(){

		    document.querySelectorAll(".dropped-block")
		        .forEach(function(block){

		            block.addEventListener("click", function(){

		                selectBlock(this);

		            });

		        });

		}
		btnUndo.addEventListener("click", function(){

		    if(historyIndex <= 0) return;

		    historyIndex--;

		    dropArea.innerHTML = history[historyIndex];

		    bindBlocks();

		});

		btnRedo.addEventListener("click", function(){

		    if(historyIndex >= history.length - 1) return;

		    historyIndex++;

		    dropArea.innerHTML = history[historyIndex];

		    bindBlocks();

		});
	});