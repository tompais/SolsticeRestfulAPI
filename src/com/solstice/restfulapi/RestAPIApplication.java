package com.solstice.restfulapi;

import com.solstice.restfulapi.mappers.GlobalExceptionHandlerMapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestAPIApplication extends Application {
}
