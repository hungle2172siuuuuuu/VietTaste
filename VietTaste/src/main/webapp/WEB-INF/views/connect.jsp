<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Connect Phantom Wallet</title>
<style>
/* Styling đơn giản cho giao diện */
body {
	font-family: Arial, sans-serif;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

#wallet-info {
	margin-top: 20px;
}
</style>
</head>
<body>
	<h1>Connect Phantom Wallet</h1>
	<button id="connect-wallet">Connect Wallet</button>
	<div id="wallet-info"></div>
	<script
		src="https://cdn.jsdelivr.net/npm/@solana/web3.js@1.35.0/lib/index.iife.min.js"></script>
	<script>
        document.getElementById('connect-wallet').addEventListener('click', async () => {
            try {
                const provider = window.solana;
                if (provider && provider.isPhantom) {
                    await provider.connect();
                    const publicKey = provider.publicKey.toString();
                    console.log('Connected to Phantom Wallet:', publicKey);
                    
                    // Hiển thị ID ví lên giao diện
                    document.getElementById('wallet-info').innerHTML = `
                        <p>Wallet ID: ${publicKey}</p>
                    `;

                    // Gửi yêu cầu đến backend
                    fetch('/api/account-info')
                        .then(response => response.json())
                        .then(data => console.log(data))
                        .catch(error => console.error('Error:', error));
                } else {
                    alert('Phantom Wallet not found. Please install it.');
                }
            } catch (error) {
                console.error('Connection failed:', error);
            }
        });
    </script>
</body>
</html>
