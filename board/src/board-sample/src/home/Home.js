import React from "react";

function Home(props) {
  localStorage.url = process.env.REACT_APP_URL;
  return <div>Main</div>;
}

export default Home;
