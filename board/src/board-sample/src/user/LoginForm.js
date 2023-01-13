import React, { useEffect, useRef, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "./UserCss.css";
import axios from "axios";
import Swal from "sweetalert2";

function LoginForm(props) {
  const [email, setEmail] = useState("");
  const [emailError, setEmailError] = useState(false); // true면 에러가 있는거, false면 에러가 없는 거
  const [emailErrorMsg, setEmailErrorMsg] = useState(
    "이메일 주소를 정확히 입력해주세요."
  );
  const [pass, setPass] = useState("");
  const [loginBtn, setLoginBtn] = useState(true); // 로그인 버튼

  const navi = useNavigate();

  const onSubmitLogin = (e) => {
    e.preventDefault();
    let signinUrl = process.env.REACT_APP_URL + "/user/login";

    axios
      .post(
        signinUrl,
        {
          email,
          pass,
        },
        { headers: { "Content-Type": "application/json" } }
      )
      .then((res) => {
        localStorage.refreshToken = res.data.refreshToken;
        localStorage.accessToken = res.data.accessToken;
        sessionStorage.u_num = res.data.u_num;
        sessionStorage.loginok = "yes";
      })
      .then((res) => {
        navi("/");
      })
      .then((res) => {
        window.location.reload();
      })
      .catch((error) => {
        localStorage.removeItem("refreshToken");
        localStorage.removeItem("accessToken");
        sessionStorage.removeItem("u_num");
        sessionStorage.removeItem("loginok");
        Swal.fire({
          icon: "error",
          text: `아이디 또는 비밀번호를 확인해주세요.`,
        });
      });
  };

  const onLoginBtnState = () => {
    if (!emailError && pass !== "") {
      setLoginBtn(false);
    } else if (emailError) {
      setLoginBtn(true);
    } else if (pass === "") {
      setLoginBtn(true);
    }
  };

  // email, pass 바뀔 때마다 렌더링
  useEffect(() => {
    onLoginBtnState();
  }, [email, pass]);

  return (
    /* eslint-disable */
    <div className="content lg" data-v-b02d33c2="">
      <div className="login_area" data-v-b02d33c2="">
        <h2 style={{ textAlign: "center" }}>
          <span>Login</span>
        </h2>
        <form onSubmit={onSubmitLogin}>
          <div
            data-v-6c561060=""
            data-v-b02d33c2=""
            className={emailError ? "input_box has_error" : "input_box"}
          >
            <h3 className="input_title" data-v-6c561060="" data-v-b02d33c2="">
              이메일 주소
            </h3>
            <div className="input_item" data-v-6c561060="">
              <input
                type="text"
                placeholder="예) ostschloss@gmail.com"
                autoComplete="off"
                className="input_txt"
                value={email}
                data-v-6c561060=""
                id="email"
                onChange={(e) => {
                  setEmail(e.target.value);
                  let exptext =
                    /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
                  if (exptext.test(email) === false) {
                    setEmailError(true);
                  } else {
                    setEmailError(false);
                  }
                  onLoginBtnState();
                }}
              />
            </div>
            <p className="input_error" data-v-6c561060="" data-v-b02d33c2="">
              {emailErrorMsg}
            </p>
          </div>
          <div data-v-6c561060="" data-v-b02d33c2="" className="input_box">
            <h3 className="input_title" data-v-6c561060="" data-v-b02d33c2="">
              비밀번호
            </h3>
            <div className="input_item" data-v-6c561060="">
              <input
                type="password"
                placeholder="영문, 숫자, 특수문자 조합 8-16자"
                autoComplete="off"
                className="input_txt"
                name="pass"
                data-v-6c561060=""
                value={pass}
                id="pass"
                onChange={(e) => {
                  setPass(e.target.value);
                  onLoginBtnState();
                }}
              />
            </div>
          </div>
          <div className="login_btn_box" data-v-b02d33c2="">
            <button
              type={"submit"}
              className="btn full solid"
              disabled={loginBtn ? true : false}
              data-v-3d1bcc82=""
              data-v-b02d33c2=""
              style={{ lineHeight: "50%" }}
            >
              로그인
            </button>
          </div>
        </form>
        <ul className="look_box" data-v-b02d33c2="">
          <li className="look_list" data-v-b02d33c2="">
            <Link to="/user/signup" className="look_link" data-v-b02d33c2="">
              {" "}
              회원가입{" "}
            </Link>
          </li>
          <li className="look_list" data-v-b02d33c2="">
            <Link
              to="/user/find_email"
              className="look_link"
              data-v-b02d33c2=""
            >
              {" "}
              아이디 찾기{" "}
            </Link>
          </li>
          <li className="look_list" data-v-b02d33c2="">
            <Link
              to="/user/find_password"
              className="look_link"
              data-v-b02d33c2=""
            >
              {" "}
              비밀번호 찾기{" "}
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
}

export default LoginForm;