import React from "react";
import { Route, Routes } from "react-router-dom";
import BoardForm from "./board/BoardForm";
import BoardDetailForm from "./boarddetail/BoardDetailForm";
import Home from "./home/Home";
import Menu from "./home/menu";
import LoginForm from "./user/LoginForm";
import SignupForm from "./user/SignupForm";

function RouteMain(props) {
  return (
    <div>
      <Routes>
        <Route
          path={"/"}
          element={
            <React.Fragment>
              <Menu />
              <Home />
            </React.Fragment>
          }
        ></Route>
        <Route path={"/user"}>
          <Route
            path={"login"}
            element={
              <React.Fragment>
                <Menu />
                <LoginForm />
              </React.Fragment>
            }
          />
          <Route
            path={"signup"}
            element={
              <React.Fragment>
                <Menu />
                <SignupForm />
              </React.Fragment>
            }
          />
        </Route>
        <Route path={"/board"}>
          <Route
            path={"list"}
            element={
              <React.Fragment>
                <Menu />
                <BoardForm />
              </React.Fragment>
            }
          >
            <Route
              path={":detail/:board_num"}
              element={
                <React.Fragment>
                  <BoardDetailForm />
                </React.Fragment>
              }
            />
            <Route
              path={":currentPage"}
              element={<React.Fragment></React.Fragment>}
            />
          </Route>
        </Route>
      </Routes>
    </div>
  );
}

export default RouteMain;
