package com.java.login.requestwrapper;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import java.io.*;

public class RequestWrapper extends ServletRequestWrapper {

    private InputStream is;
    public RequestWrapper(ServletRequest request) {
        super(request);
        copyStream(request);

    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(is));
    }

    private void copyStream(ServletRequest request)
    {
        try {
            InputStream sourceStream = request.getInputStream();
            int len = 0;
            byte buffer[] = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = sourceStream.read(buffer)) > -1)
            {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            is = new ByteArrayInputStream(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public ServletRequest getRequest() {
        return super.getRequest();
    }

    @Override
    public void setRequest(ServletRequest request) {
        super.setRequest(request);
    }
}
