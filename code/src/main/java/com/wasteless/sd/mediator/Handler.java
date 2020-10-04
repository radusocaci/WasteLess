package com.wasteless.sd.mediator;

public interface Handler<T extends Request, R extends Response> {

    R handle(T request);
}
