document.addEventListener("DOMContentLoaded", function() {
    const xApiKey = "gm8MMyC1Go7K6dBZ"; // Nhập API Key của bạn ở đây
    const displayPic = document.getElementById("displayPic");
    const fileInput = document.getElementById("fileInput");
    const selectFileButton = document.getElementById("selectFileButton");
    const status = document.getElementById("status");
    const response = document.getElementById("response");

    selectFileButton.addEventListener("click", function() {
        fileInput.click();
    });

    fileInput.addEventListener("change", function(e) {
        const [file] = e.target.files;
        if (file) {
            displayPic.src = URL.createObjectURL(file);
        }
    });

    document.getElementById("create-nft-form").addEventListener("submit", function(e) {
        e.preventDefault();

        const formData = new FormData();
        formData.append("network", document.getElementById("network").value);
        formData.append("wallet", document.getElementById("publicKey").value);
        formData.append("name", document.getElementById("name").value);
        formData.append("symbol", document.getElementById("symbol").value);
        formData.append("description", document.getElementById("desc").value);
        formData.append("attributes", document.getElementById("attr").value);
        formData.append("external_url", document.getElementById("extUrl").value);
        formData.append("file", fileInput.files[0]);

        status.textContent = "Loading...";

        fetch("https://api.shyft.to/sol/v1/nft/create_detach", {
            method: "POST",
            headers: {
                "Content-Type": "multipart/form-data",
                "x-api-key": xApiKey,
                "Accept": "*/*",
                "Access-Control-Allow-Origin": "*"
            },
            body: formData
        })
        .then(response => response.json())
        .then(async (res) => {
            if (res.success === true) {
                status.textContent = "Transaction Created. Signing Transactions. Please Wait.";
                // Giả định bạn có hàm signAndConfirmTransactionFe trong một file JS khác
                const transaction = res.result.encoded_transaction;
                const ret_result = await signAndConfirmTransactionFe(transaction);
                status.textContent = "Successfully Signed and Minted.";
                response.value = JSON.stringify(res, null, 2);
            } else {
                status.textContent = "Failed to create transaction.";
                response.value = JSON.stringify(res, null, 2);
            }
        })
        .catch(err => {
            console.warn(err);
            status.textContent = "Error: Could not complete the transaction.";
        });
    });

    async function signAndConfirmTransactionFe(transaction) {
        // Hàm giả định để ký và xác nhận giao dịch
        // Bạn cần phải thay thế nó bằng logic thực tế của bạn
        console.log("Signing and confirming transaction:", transaction);
        return { signature: "dummy_signature", result: "dummy_result" };
    }
});
