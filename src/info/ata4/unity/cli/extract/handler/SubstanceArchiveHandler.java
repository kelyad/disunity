/*
 ** 2013 June 16
 **
 ** The author disclaims copyright to this source code.  In place of
 ** a legal notice, here is a blessing:
 **    May you do good and not evil.
 **    May you find forgiveness for yourself and forgive others.
 **    May you share freely, never taking more than you give.
 */
package info.ata4.unity.cli.extract.handler;

import info.ata4.unity.asset.struct.AssetObjectPath;
import info.ata4.unity.serdes.UnityBuffer;
import info.ata4.unity.serdes.UnityObject;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 *
 * @author Nico Bergemann <barracuda415 at yahoo.de>
 */
public class SubstanceArchiveHandler extends ExtractHandler {
    
    @Override
    public String getClassName() {
        return "SubstanceArchive";
    }
    
    public String getExtension() {
        return "sbsar";
    }

    @Override
    public void extract(AssetObjectPath path, UnityObject obj) throws IOException {
        String name = obj.getValue("m_Name");
        UnityBuffer packageData = obj.getValue("m_PackageData");
        ByteBuffer packageBuffer = packageData.getBuffer();
        
        writeFile(packageBuffer, path.pathID, name);
    }
}
