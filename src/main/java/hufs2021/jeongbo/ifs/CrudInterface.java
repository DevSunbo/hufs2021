package hufs2021.jeongbo.ifs;

import hufs2021.jeongbo.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create();

//    Header<Res> readAll();

    Header<Res> read();

    Header<Res> update();

    Header delete();
}
