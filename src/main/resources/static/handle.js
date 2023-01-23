let counter = 0;
const handleSubmit = (e) => {
  e.preventDefault();
  const guessInput = document.getElementById("guessNumInput");
  const randInput = document.getElementById("randNumInput");
  const alert = document.getElementById("guessNumAlert");
  counter += 1;
  if (guessInput && randInput && alert) {
    const guessIptVal = parseInt(guessInput.value);
    const randIptVal = parseInt(randInput.value);
    alert.classList.remove("d-none");
    alert.classList.add("alert-info");
    if (guessIptVal > randIptVal) {
      alert.innerHTML = "Your number is greater than result!";
    } else if (guessIptVal < randIptVal) {
      alert.innerHTML = "Your number is less than result!";
    } else {
      alert.classList.remove("alert-info");
      alert.classList.add("alert-success");
      alert.innerHTML = "Bingo!";
      setTimeout(async () => {
        try {
            await fetch(`/api/bingo/${counter}`, {method: "POST"});
            window.location.reload();
          } catch (error) {
            
          } finally {
            counter = 0;
          }
      }, 1000);
    }
  }
};

window.onload = () => {
  const alert = document.getElementById("guessNumAlert");
  const input = document.getElementById("guessNumInput");
  const form = document.getElementById("guessNumForm");
  if (alert && input && form) {
    form.onsubmit = handleSubmit;
  }
};
