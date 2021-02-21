import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { Col} from 'react-bootstrap';

const QnaFont1 = styled.div`
    font-size: 30px;
    margin-top: 10px;
    font-weight: bold;
`;

const QnaFont2 = styled.div`
    font-size: 25px;
    font-weight: normal;
    margin-top: 40px;
    vertical-align: middle;
`;

const QnaFont3 = styled.div`
    height: auto;
    padding: 0px 30px 30px 30px;
`;

const QnaSideBar = ({searchColor, registerColor}) => {
    return (
        <>
            <Col md={{span: 3}}>
                <QnaFont3 className="text-center">
                    <QnaFont1>QnA</QnaFont1>
                    <QnaFont2 className="align-self-center">
                        <Link to="/qna">
                            <div className={searchColor}>조회</div>
                        </Link>
                        <Link to="/qna/register">
                            <div className={"mt-3 " + registerColor}>작성</div>
                        </Link>
                    </QnaFont2>
                </QnaFont3>
            </Col>        
        </>
    );
}

QnaSideBar.defaultProps = {
    searchColor: "text-body",
    registerColor: "text-body"
}

export default QnaSideBar;