package com.cifs.cifs;

import jcifs.smb.SmbRandomAccessFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Vladislav Bauer
 */

public class SmbFileInputStream extends InputStream {

    private final SmbRandomAccessFile raf;


    public SmbFileInputStream(final SmbRandomAccessFile raf) {
        this.raf = raf;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int read() throws IOException {
        return raf.readByte();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long skip(final long n) throws IOException {
        raf.seek(raf.getFilePointer() + n);
        return n;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws IOException {
        raf.close();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int read(final byte[] b) throws IOException {
        return raf.read(b);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int read(final byte[] b, final int off, final int len) throws IOException {
        return raf.read(b, off, len);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int available() throws IOException {
        final long available = raf.length() - raf.getFilePointer();
        return (int) Math.min(available, Integer.MAX_VALUE);
    }

}
