import { fetchArtists } from "./apiHelper.js";
import { createFooter } from "./components/footer.js";
import { createHeader } from "./components/header.js";
import { createAllArtistsSection } from "./components/allArtistsSection.js";

export const renderPage = (allArtists) => {
  const container = document.querySelector(".container");
  while (container.firstChild) {
    container.firstChild.remove();
  }
  container.prepend(createHeader());
  container.appendChild(createAllArtistsSection(allArtists));
  container.appendChild(createFooter());
  document.querySelector("#artist-layout").disabled = true;
};

fetchArtists().then((artists) => {
  renderPage(artists);
});
