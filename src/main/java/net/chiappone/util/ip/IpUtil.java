package net.chiappone.util.ip;

/**
 * @author Kurtis Chiappone
 */
public class IpUtil {

    /**
     * Converts a String IP address to a long String representation.
     *
     * @param ip the IP address to convert
     * @return a long String representation of the IP address
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
     * Converts a String IP address to a long.
     *
     * @param ip the IP address to convert
     * @return a long representation of the IP address
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
