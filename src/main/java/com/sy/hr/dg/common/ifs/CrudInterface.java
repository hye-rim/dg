package com.sy.hr.dg.common.ifs;

import com.sy.hr.dg.model.network.Header;

import java.util.Optional;
public interface CrudInterface<> {

    Header<Res> regist(Header<Object> request);    // todo request object 추가

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header delete(Long id);

}
