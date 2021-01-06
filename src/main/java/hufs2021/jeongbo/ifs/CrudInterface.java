package hufs2021.jeongbo.ifs;

import hufs2021.jeongbo.network.Header;

public interface CrudInterface<Req, Res> {

    Header<Res> create(Header<Req> request);

//    Header<Res> readAll();

    Header<Res> read(Integer id);

    Header<Res> update(Header<Req> request);

    Header delete(Integer id);
}
