import React from 'react';
import '../App.css';
import {Route} from 'react-router-dom';
import Home from "../page/Home";
import Login from "../page/Login";
import Join from "../page/Join";
import TeamSearch from "../page/TeamProjectSearch";
import AssetSearch from "../page/AssetSearch";
import AssetApply from "../page/AssetApply";
import FindId from "../page/FindId";
import FindPW from "../page/FindPW";
import StudyroomSearch from "../page/StudyroomSearch";
import StudyroomReserve from "../page/StudyroomReserve";
import QnASearch from "../page/QnASearch";
import QnARegister from "../page/QnARegister";
import QnADetail from "../page/QnADetail";
import TeamProjectApply from "../page/TeamProjectApply";
import TeamProjectMyDetail from "../page/myPage/TeamProjectMyDetail";
import TeamProjectRegister from "../page/TeamProjectRegister";
import TeamProjectDetail from "../page/TeamProjectDetail";
import AssetCategory from "../page/admin/AssetCategory";
import AssetDetail from "../page/admin/AssetDetail";
import AssetHistory from "../page/admin/AssetHistory";
import AssetManage from "../page/admin/AssetManage";
import AssetRegister from "../page/admin/AssetRegister";
import AssetRent from "../page/admin/AssetRent";
import StudyroomHistory from "../page/admin/StudyroomHistory";
import StudyroomManage from "../page/admin/StudyroomManage";
import StudyroomRegister from "../page/admin/StudyroomRegister";
import AssetMyInfo from "../page/myPage/AssetMyInfo";
import ChangePassword from "../page/myPage/ChangePassword";
import QnAMyInfo from "../page/myPage/QnAMyInfo";
import QnaMyInfoDetail from "../page/myPage/QnaMyInfoDetail";
import StudyroomMyInfo from "../page/myPage/StudyroomMyInfo";
import TeamProjectApplication from "../page/myPage/TeamProjectApplication";
import TeamProjectMyApplyInfo from "../page/myPage/TeamProjectMyApplyInfo";
import TeamProjectMyInfo from "../page/myPage/TeamProjectMyInfo";
import UserInfoModify from "../page/myPage/UserInfoModify";


const App = () => {
    return (
        <>
            <Route path="/" component={Home} exact={true}/>
            <Route path="/login" component={Login}/>
            <Route path="/find-id" component={FindId}/>
            <Route path="/find-pw" component={FindPW}/>
            <Route path="/join" component={Join}/>


            {/*Asset*/}
            <Route path="/asset" component={AssetSearch} exact = {true}/>
            <Route path="/asset/apply" component={AssetApply} />

            {/*Studyroom*/}
            <Route path="/studyroom" component={StudyroomSearch} exact={true}/>
            <Route path="/studyroom/reserve" component={StudyroomReserve}/>

            {/*QnA*/}
            <Route path="/qna" component={QnASearch} exact={true}/>
            <Route path="/qna/register" component={QnARegister}/>
            <Route path="/qna/detail" component={QnADetail}/>

            {/*TeamProject*/}
            <Route path="/team-project" component={TeamSearch} exact={true}/>
            <Route path="/team-project/apply" component={TeamProjectApply}/>
            <Route path="/team-project/register" component={TeamProjectRegister}/>
            <Route path="/team-project/detail" component={TeamProjectDetail}/>

            {/*% admin %*/}
            {/*Asset*/}
            <Route path="/admin/asset/category" component={AssetCategory} />
            <Route path="/admin/asset/detail" component={AssetDetail} />
            <Route path="/admin/asset/history" component={AssetHistory} />
            <Route path="/admin/asset/manage" component={AssetManage} />
            <Route path="/admin/asset/register" component={AssetRegister} />
            <Route path="/admin/asset/rent" component={AssetRent} />

            {/*Studyroom*/}
            <Route path="/admin/studyroom/history" component={StudyroomHistory}/>
            <Route path="/admin/studyroom/manage" component={StudyroomManage}/>
            <Route path="/admin/studyroom/register" component={StudyroomRegister}/>

            {/*mypage*/}
            <Route path="/user/change/userinfo" component={UserInfoModify} />
            <Route path="/user/change/password" component={ChangePassword} />

            <Route path="/user/asset/rent" component={AssetMyInfo} />
            <Route path="/user/studyroom/info" component={StudyroomMyInfo} />
            <Route path="/user/qna/info" component={QnAMyInfo} />
            <Route path="/user/qna/detail" component={QnaMyInfoDetail} />
            <Route path="/user/team-project/application" component={TeamProjectApplication} />
            <Route path="/user/team-project/apply-info" component={TeamProjectMyApplyInfo} />
            <Route path="/user/team-project/mydetail" component={TeamProjectMyDetail} />
            <Route path="/user/team-project/info" component={TeamProjectMyInfo} />
        </>
    );
}

export default App;
