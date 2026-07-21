// =====================================================
// MAKE WEB NOW - EDITOR V2
// Canva + Scratch Style
// =====================================================

document.addEventListener("DOMContentLoaded", function () {

    // ============================================
    // COMPONENTS
    // ============================================

    const blockItems = document.querySelectorAll(".block-item");
    const dropArea = document.getElementById("drop-area");

    const textArea = document.querySelector("textarea");

    const colorInputs =
        document.querySelectorAll(".form-control-color");

    const textColor = colorInputs[0];
    const backgroundColor = colorInputs[1];

    const btnDelete =
        document.getElementById("btnDelete");

    const btnDuplicate =
        document.getElementById("btnDuplicate");

    const btnUp =
        document.getElementById("btnUp");

    const btnDown =
        document.getElementById("btnDown");

    const btnSave =
        document.getElementById("btnSave");

    const btnDashboard =
        document.getElementById("btnDashboard");

    const websiteID =
        document.getElementById("websiteID");

    // ============================================
    // VARIABLES
    // ============================================

    let dragType = "";

    let selectedBlock = null;

    let hasChanged = false;

    // ============================================
    // DRAG START
    // ============================================

    blockItems.forEach(item => {

        item.addEventListener("dragstart", function () {

            dragType = this.innerText.trim();

        });

    });

    // ============================================
    // DROP AREA
    // ============================================

    dropArea.addEventListener("dragover", function (e) {

        e.preventDefault();

    });

    // ============================================
    // DROP BLOCK
    // ============================================

    dropArea.addEventListener("drop", function (e) {

        e.preventDefault();

        const block =
            document.createElement("div");

        block.className = "dropped-block";

        switch (dragType) {

            case "Header":

                block.innerHTML =
                    "<h2 contenteditable='true'>Tiêu đề</h2>";

                break;

            case "Text":

                block.innerHTML =
                    "<p contenteditable='true'>Đây là đoạn văn bản.</p>";

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
                    "<footer contenteditable='true'>Footer</footer>";

                break;

            default:

                return;

        }

        block.addEventListener("click", function () {

            selectBlock(this);

        });

        dropArea.appendChild(block);

        hasChanged = true;

    });

    // ============================================
    // SELECT BLOCK
    // ============================================

    function selectBlock(block) {

        document.querySelectorAll(".dropped-block")
            .forEach(item => {

                item.style.border =
                    "2px dashed #ffc3df";

            });

        selectedBlock = block;

        selectedBlock.style.border =
            "3px solid #ff5ea8";

        updatePropertyPanel();

    }

    // ============================================
    // PROPERTY PANEL
    // ============================================

    function updatePropertyPanel() {

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
		// ============================================
		// EDIT CONTENT
		// ============================================

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

		});

		// ============================================
		// TEXT COLOR
		// ============================================

		textColor.addEventListener("input", function () {

		    if (!selectedBlock) return;

		    selectedBlock.style.color = this.value;

		    hasChanged = true;

		});

		// ============================================
		// BACKGROUND COLOR
		// ============================================

		backgroundColor.addEventListener("input", function () {

		    if (!selectedBlock) return;

		    selectedBlock.style.backgroundColor = this.value;

		    hasChanged = true;

		});

		// ============================================
		// DELETE BLOCK
		// ============================================

		btnDelete.addEventListener("click", function () {

		    if (!selectedBlock) return;

		    if (!confirm("Xóa Block này?")) return;

		    selectedBlock.remove();

		    selectedBlock = null;

		    textArea.value = "";

		    hasChanged = true;

		});

		// ============================================
		// DUPLICATE BLOCK
		// ============================================

		btnDuplicate.addEventListener("click", function () {

		    if (!selectedBlock) return;

		    const clone = selectedBlock.cloneNode(true);

		    clone.addEventListener("click", function () {

		        selectBlock(clone);

		    });

		    dropArea.appendChild(clone);

		    selectBlock(clone);

		    hasChanged = true;

		});

		// ============================================
		// MOVE UP
		// ============================================

		btnUp.addEventListener("click", function () {

		    if (!selectedBlock) return;

		    const prev = selectedBlock.previousElementSibling;

		    if (prev) {

		        dropArea.insertBefore(selectedBlock, prev);

		        hasChanged = true;

		    }

		});

		// ============================================
		// MOVE DOWN
		// ============================================

		btnDown.addEventListener("click", function () {

		    if (!selectedBlock) return;

		    const next = selectedBlock.nextElementSibling;

		    if (next) {

		        dropArea.insertBefore(next, selectedBlock);

		        hasChanged = true;

		    }
			// ============================================
			// SAVE PROJECT
			// ============================================

			btnSave.addEventListener("click", function () {

			    const data = [];

			    document.querySelectorAll(".dropped-block").forEach(block => {

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

			        data.push({
			            type: type,
			            text: text,
			            color: block.style.color,
			            background: block.style.backgroundColor
			        });

			    });

			    fetch("saveProject", {

			        method: "POST",

			        headers: {
			            "Content-Type": "application/x-www-form-urlencoded"
			        },

			        body:
			            "websiteID=" + encodeURIComponent(websiteID.value) +
			            "&content=" + encodeURIComponent(JSON.stringify(data))

			    })
			    .then(res => res.text())
			    .then(result => {

			        if (result.trim() === "success") {

			            hasChanged = false;

			            alert("Đã lưu Project!");

			        } else {

			            alert("Lưu thất bại!");

			        }

			    })
			    .catch(() => {

			        alert("Có lỗi khi lưu Project!");

			    });

			});

			// ============================================
			// HOME (Canva Style)
			// ============================================

			btnDashboard.addEventListener("click", function (e) {

			    e.preventDefault();

			    if (!hasChanged) {

			        window.location.href = "dashboard";
			        return;

			    }

			    const saveBeforeExit = confirm(
			        "Bạn có muốn lưu Project trước khi quay về Trang chủ?"
			    );

			    if (saveBeforeExit) {

			        btnSave.click();

			        setTimeout(function () {

			            window.location.href = "dashboard";

			        }, 800);

			    } else {

			        window.location.href = "dashboard";

			    }

			});

			// ============================================
			// PREVIEW
			// ============================================

			const btnPreview = document.querySelector(".btn-preview");

			if (btnPreview) {

			    btnPreview.addEventListener("click", function () {

			        alert("Preview sẽ được hoàn thiện ở bước tiếp theo.");

			    });

			}

			// ============================================
			// DOWNLOAD
			// ============================================

			const btnDownload = document.querySelector(".btn-download");

			if (btnDownload) {

			    btnDownload.addEventListener("click", function () {

			        alert("Tính năng Download sẽ được hoàn thiện ở bước tiếp theo.");

			    });

			}

		});