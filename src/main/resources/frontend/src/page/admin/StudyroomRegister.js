import React from 'react';
import {Row, Col, Form, Button, Modal} from 'react-bootstrap';
import Select from "react-select";

const groupStyles = {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'space-between',
};
const groupBadgeStyles = {
    backgroundColor: '#EBECF0',
    borderRadius: '2em',
    color: '#172B4D',
    display: 'inline-block',
    fontSize: 12,
    fontWeight: 'normal',
    lineHeight: '1',
    minWidth: 1,
    padding: '0.16666666666667em 0.5em',
    textAlign: 'center',
};

const formatGroupLabel = data => (
    <div style={groupStyles}>
        <span>{data.label}</span>
        <span style={groupBadgeStyles}>{data.options.length}</span>
    </div>
);
const roomId = [{value: '306', label: '306'},
    {value: '426', label: '426'},
];

const roomNumber = [
    {value: '1', label: '1'},
    {value: '2', label: '2'},
    {value: '3', label: '3'},
    {value: '4', label: '4'}
]


const StudyroomRegister = (props) => {

        return (
            <Modal {...props}  centered>
                <Modal.Body>
                    <div className="mt-2 border p-4">
                        <Form>
                            <Row>
                                <Col>
                                    <Form.Label>방호실</Form.Label>
                                    <Select defaultValue={{value: '', label: 'select'}}
                                            options={roomId}
                                            formatGroupLabel={formatGroupLabel}
                                    />
                                </Col>
                                <Col>
                                    <Form.Label>번호</Form.Label>
                                    <Select defaultValue={{value: '', label: 'select'}}
                                            options={roomNumber}
                                            formatGroupLabel={formatGroupLabel}
                                    />
                                </Col>
                                <Col>
                                    <Form.Label>이용가능학과</Form.Label>
                                    <Select defaultValue={{value: '', label: '학과선택'}}
                                            formatGroupLabel={formatGroupLabel}
                                    />
                                </Col>
                            </Row>
                            <Row>
                                <Form.Label>상태</Form.Label>
                                <Select defaultValue={{value: '', label: '상태'}}
                                        formatGroupLabel={formatGroupLabel}
                                />
                            </Row>
                        </Form>
                    </div>
                </Modal.Body>
                <Modal.Footer>
                    <div className="m-auto">
                        <Button variant="danger" className="mr-2" onClick={props.onHide}>취소</Button>
                        <Button onClick={props.onHide}>저장</Button>
                    </div>
                </Modal.Footer>
            </Modal>
        );
}

export default StudyroomRegister;