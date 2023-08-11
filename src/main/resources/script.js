const axios = require("axios");

const getCards = async (boardId) => {
  const response = await axios.get(`https://localhost:8080/api/boards/${boardId}/cards`);
  if (response.status === 200) {
    const cards = response.data;
    const sections = {
      1: document.getElementById("sectionToDo"),
      2: document.getElementById("sectionInProgress"),
      3: document.getElementById("sectionDone"),
    };
    cards.forEach((card) => {
      const section = sections[card.sectionId];
      if (section) {
        const cardElement = document.createElement("div");
        cardElement.innerHTML = `
          <h3>${card.title}</h3>
          <p>${card.description}</p>
        `
        section.appendChild(cardElement);
      }
    });
  }
};

const main = async () => {
  const boardId = document.getElementById("boardId").value;
  await getCards(boardId);
};

main();
