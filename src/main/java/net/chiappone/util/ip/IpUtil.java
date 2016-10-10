package net.chiappone.util.ip;

/**
 * @author Kurtis Chiappone
 * @date 10/9/2016
 */
public class IpUtil {

    /**
     * @param ip
     * @return
     */
    public static String longToIp( String ip ) {

        Long ipLong = Long.valueOf( ip );
        StringBuilder result = new StringBuilder( 15 );

        for ( int i = 0; i < 4; i++ ) {

            result.insert( 0, Long.toString( ipLong & 0xff ) );

            if ( i < 3 ) {

                result.insert( 0, '.' );

            }

            ipLong = ipLong >> 8;

        }

        return result.toString();

    }

    /**
     * @param ip
     * @return
     */
    public static long ipToLong( String ip ) {

        String[] ipArray = ip.split( "\\." );

        long num = 0;

        for ( int i = 0; i < ipArray.length; i++ ) {

            int power = 3 - i;

            num += ( ( Integer.parseInt( ipArray[ i ] ) % 256 * Math.pow( 256, power ) ) );

        }

        return num;

    }

}
