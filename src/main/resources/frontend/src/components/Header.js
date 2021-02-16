import React, {useState} from 'react';
import styled from 'styled-components';
import {Button, Row, Col, Dropdown} from 'react-bootstrap';
import {Link} from 'react-router-dom'


const HomeLink = styled.div`
    font-size: 35px;
    text-color: black;
`;

const BarLink = styled.div`
    font-size: 25px;
`


const Header = () => {
    const [assetShow, setAssetShow] = useState(false);
    const [studyroomShow, setStudyroomShow] = useState(false);
    const [teamprojectShow, setTeamprojectShow] = useState(false);
    const [qnaShow, setQnAShow] = useState(false);

    const showAssetDropdown = (e) => {setAssetShow(!assetShow);}
    const showSturyroomDropdown = (e) => {setStudyroomShow(!studyroomShow);}
    const showTeamprojectDropdown = (e) => {setTeamprojectShow(!teamprojectShow);}
    const showQnADropdown = (e) => {setQnAShow(!qnaShow);}

    const hideAssetDropdown = e => {setAssetShow(false);}
    const hideStudyroomDropdown = e => {setStudyroomShow(false);}
    const hideTeamprojectDropdown = e => {setTeamprojectShow(false);}
    const hideQnADropdown = e => {setQnAShow(false);}

    return (
        <>
            <Row className="mt-4">
                <Col md={{span: 4, offset: 2}}>
                    <HomeLink><Link to="/">컴퓨터 공학부</Link></HomeLink>
                </Col>
                <Col md={{span: 4, offset: 2}} className="text-center">
                    <Link to="/admin/asset/manage">
                        <Button  variant="light">Admin</Button>
                    </Link>
                    <Link to="/login">
                        <Button variant="light" className="mr-2">로그인</Button>                
                    </Link>
                    <Link to="/join">
                        <Button variant="light">회원가입</Button>
                    </Link>
                </Col>
            </Row>
            <Row className="justify-content-center mt-4">
                <Col md={{span: 8}} className="border text-center">
                    <div className="d-flex justify-content-around">
                        <BarLink to={"/asset"} md={{span: 3}}>
                            <Dropdown title="Dropdown"
                                      id="collasible-nav-dropdown"
                                      show={assetShow}
                                      onMouseEnter={showAssetDropdown}
                                      onMouseLeave={hideAssetDropdown}>
                                <Dropdown.Toggle>기자재</Dropdown.Toggle>
                                <Dropdown.Menu>
                                    <Dropdown.Item><Link to="/asset">기자재조회</Link></Dropdown.Item>
                                    <Dropdown.Item><Link to="/asset/apply">기자재신청</Link></Dropdown.Item>
                                </Dropdown.Menu>
                            </Dropdown>
                        </BarLink>
                        <BarLink md={{span: 3}}>
                            <Dropdown title="Dropdown"
                                      id="collasible-nav-dropdown"
                                      show={studyroomShow}
                                      onMouseEnter={showSturyroomDropdown}
                                      onMouseLeave={hideStudyroomDropdown}>
                                <Dropdown.Toggle>스터디룸</Dropdown.Toggle>
                                <Dropdown.Menu>
                                    <Dropdown.Item><Link to="/studyroom">스터디룸조회</Link></Dropdown.Item>
                                    <Dropdown.Item><Link to="/studyroom/reserve">스터디룸예약</Link></Dropdown.Item>
                                </Dropdown.Menu>
                            </Dropdown>
                        </BarLink>
                        <BarLink md={{span: 3}}>
                            <Dropdown title="Dropdown"
                                      id="collasible-nav-dropdown"
                                      show={teamprojectShow}
                                      onMouseEnter={showTeamprojectDropdown}
                                      onMouseLeave={hideTeamprojectDropdown}>
                                <Dropdown.Toggle>팀프로젝트</Dropdown.Toggle>
                                <Dropdown.Menu>
                                    <Dropdown.Item><Link to="/team-project">팀프로젝트조회</Link></Dropdown.Item>
                                    <Dropdown.Item><Link to="/team-project/apply">팀프로젝트신청</Link></Dropdown.Item>
                                    <Dropdown.Item><Link to="/team-project/register">팀프로젝트등록</Link></Dropdown.Item>
                                </Dropdown.Menu>
                            </Dropdown>
                        </BarLink>
                        <BarLink md={{span: 3}}>
                            <Dropdown title="Dropdown"
                                      id="collasible-nav-dropdown"
                                      show={qnaShow}
                                      onMouseEnter={showQnADropdown}
                                      onMouseLeave={hideQnADropdown}>
                                <Dropdown.Toggle>QnA</Dropdown.Toggle>
                                <Dropdown.Menu>
                                    <Dropdown.Item><Link to="/qna">QnA조회</Link></Dropdown.Item>
                                    <Dropdown.Item><Link to="/qna/register">QnA등록</Link></Dropdown.Item>
                                </Dropdown.Menu>
                            </Dropdown>
                        </BarLink>
                        <BarLink md={{span: 3}}>
                            <Link to="/user/change/userinfo">마이페이지</Link>
                        </BarLink>
                    </div>
                </Col>
            </Row>
        </>
    );
}

export default Header;