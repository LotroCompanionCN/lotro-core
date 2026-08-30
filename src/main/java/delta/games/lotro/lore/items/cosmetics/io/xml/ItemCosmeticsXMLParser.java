package delta.games.lotro.lore.items.cosmetics.io.xml;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import delta.common.utils.NumericTools;
import delta.games.lotro.lore.items.cosmetics.ItemCosmetics;

/**
 * SAX parser for item cosmetics.
 * @author DAM
 */
public final class ItemCosmeticsXMLParser extends DefaultHandler
{
  private static final Logger LOGGER=LoggerFactory.getLogger(ItemCosmeticsXMLParser.class);

  private ItemCosmetics _result;

  private ItemCosmeticsXMLParser()
  {
    _result=new ItemCosmetics();
  }

  /**
   * Parse the XML file.
   * @param source Source file.
   * @return List of parsed items.
   */
  public static ItemCosmetics parseFile(File source)
  {
    try
    {
      ItemCosmeticsXMLParser handler=new ItemCosmeticsXMLParser();
      SAXParserFactory factory=SAXParserFactory.newInstance();
      factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
      SAXParser saxParser=factory.newSAXParser();
      InputStream is=openGzipAwareStream(source);
      if (is==null)
      {
        LOGGER.error("Cannot open items cosmetics file "+source);
        return null;
      }
      saxParser.parse(new InputSource(is),handler);
      saxParser.reset();
      return handler._result;
    }
    catch (Exception e)
    {
      LOGGER.error("Error when loading items file "+source,e);
    }
    return null;
  }

  private static InputStream openGzipAwareStream(File source)
  {
    if (source==null)
    {
      return null;
    }
    if (source.getName().endsWith(".gz") && source.exists())
    {
      try { return new GZIPInputStream(new BufferedInputStream(new FileInputStream(source))); } catch(Exception e) {}
    }
    try { return new BufferedInputStream(new FileInputStream(source)); } catch(Exception e) {}
    File gz=new File(source.getAbsolutePath()+".gz");
    if (gz.exists()) { try { return new GZIPInputStream(new BufferedInputStream(new FileInputStream(gz))); } catch(Exception e) {} }
    return null;
  }

  @Override
  public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException
  {
    if (ItemCosmeticsXMLConstants.COSMETIC_TAG.equals(qualifiedName))
    {
      // ItemIDs
      String itemIDsStr=attributes.getValue(ItemCosmeticsXMLConstants.COSMETIC_ITEM_IDS_ATTR);
      String[] itemIDStrs=itemIDsStr.split(",");
      int[] itemIDs=new int[itemIDStrs.length];
      for(int i=0;i<itemIDs.length;i++)
      {
        itemIDs[i]=NumericTools.parseInt(itemIDStrs[i],0);
      }
      _result.addEntry(itemIDs);
    }
  }
}
